package com.comic.controller;

import com.comic.model.*;
import com.comic.service.*;
import com.comic.util.JsonResult;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

@RestController
public class filmController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    @Autowired
    FilmService filmService;
    @Autowired
    EvaluationService evaluationService;
    @Autowired
    UserinfoService userinfoService;
    @Autowired
    OrderService orderService;
    @Autowired
    ScheduleService scheduleService;
    List<Film> filmArrayList=new ArrayList<>();
    @RequestMapping("/admin/filmlist")
    public PageInfo<Film> showFilmlist(String page,String search){

        int pageSize = 4;
        if (search.equals("nothing")) {
            filmArrayList = filmService.selectFilmByPage(Integer.parseInt(page), pageSize);
        }else {
            filmArrayList=filmService.searchFilm(search, Integer.parseInt(page),pageSize);
        }
        PageInfo<Film> pageInfo=new PageInfo<>(filmArrayList);
        return pageInfo;
    }
    @RequestMapping("/admin/addFilm")
    public JsonResult<Void> add(String filmname, String back, String area,String ticai,String filmtype,String fare,String filmdate){
        Film film=new Film();
        film.setFilmname(filmname);
        film.setBack(back);
        film.setArea(area);
        film.setTicai(ticai);
        film.setFilmtype(filmtype);
        film.setFare(fare);
        String a=filmdate.replace("T"," ");
        Date date=null;
        try {
            date=sdf.parse(a);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        film.setFilmdate(date);
        film.setSentiment(1000);
        System.out.println(film);
        if (filmService.addFilm(film)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/updateFilm")
    public JsonResult<Void> update(String film_id,String filmname, String back, String area,String ticai,String filmtype,String fare,String filmdate){
        Film film=new Film();
        film.setFilm_id(film_id);
        film.setFilmname(filmname);
        film.setBack(back);
        film.setArea(area);
        film.setTicai(ticai);
        film.setFilmtype(filmtype);
        film.setFare(fare);
        String a=filmdate.replace("T"," ");
        Date date=null;
        try {
            date=sdf.parse(a);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        film.setFilmdate(date);
        film.setSentiment(filmService.selectFilm(film_id).getSentiment());
        if (filmService.updateFilm(film)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/selectFilm")
    public JsonResult<Film> selectFilm(String film_id){

        if (filmService.selectFilm(film_id)!=null){
            return new JsonResult<>(1,filmService.selectFilm(film_id));
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/deleteFilm")
    public JsonResult<Void> deleteFilm(String film_id){

        if (filmService.deleteFilm(film_id)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/user/showFilm")
    public List<Film> showFilm(String search){
        List<Film> filmList=new ArrayList<>();
        if (search.equals("nothing")){
            filmList=filmService.selectFilmByPage(1,30);
        }else {
            filmList=filmService.searchFilm(search,1,30);
        }
        return filmList;
    }
    @RequestMapping("/user/showFilmInfo")
    public FilmInfo showFilmInfo(String film_id, HttpSession session){
        User user= (User) session.getAttribute("user1");
        Film film=new Film();
        FilmInfo filmInfo=new FilmInfo();
        List<Evaluation> evaluationList=evaluationService.selecteva(film_id);
        Userinfo userinfo=userinfoService.selectuser(user.getUser_id());
        List<Schedule> scheduleList=scheduleService.selectbyfilm(film_id);
        film=filmService.selectFilm(film_id);
        filmInfo.setFilm(film);
        filmInfo.setEvaluationList(evaluationList);
        filmInfo.setUserinfo(userinfo);
        filmInfo.setScheduleList(scheduleList);

        return filmInfo;
    }
    @RequestMapping("/user/addEva")
    public JsonResult<Void> addEva(String text,String film_id,HttpSession session){
        User user= (User) session.getAttribute("user1");
        Film film=filmService.selectFilm(film_id);
        Date now=new Date();
        Evaluation evaluation=new Evaluation(film_id,film.getFilmname(),user.getUser_id(),user.getUsername(),text,"五星","0",now);
        evaluationService.addeva(evaluation);
        return new JsonResult<>(1);
    }
    @RequestMapping("/showseat")
    public List<Order> showseat(String schedule_id){
       List<Order> orderList=orderService.sellectbyschid(Integer.parseInt(schedule_id));
        return orderList;
    }
    @RequestMapping("/addorder")
    public JsonResult<Void> addorder(String filmname,String schedule_id,String seat,HttpSession session){
        User user= (User) session.getAttribute("user1");
        Date now=new Date();
        Order order=new Order();
        order.setFilmname(filmname);
        order.setUsername(user.getUsername());
        order.setOrdertime(now);
        order.setSchedule_id(Integer.parseInt(schedule_id));
        order.setSeat(seat);
        System.out.println(order);
        orderService.addorder(order);
        return new JsonResult<>(1);
    }
}
