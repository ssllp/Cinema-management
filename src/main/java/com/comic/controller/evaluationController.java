package com.comic.controller;

import com.comic.model.Evaluation;
import com.comic.service.EvaluationService;
import com.comic.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class evaluationController {
    @Autowired
    EvaluationService evaluationService;
    List<Evaluation> evaluationArrayList=new ArrayList<>();
    @RequestMapping("/admin/evalist")
    public PageInfo<Evaluation> showevaluationlist(String page,String search){
        int pageSize = 5;
        if (search.equals("nothing")) {
            evaluationArrayList = evaluationService.selectEvaByPage(Integer.parseInt(page), pageSize);
        }else {
            evaluationArrayList=evaluationService.searchEva(search, Integer.parseInt(page),pageSize);
        }
        PageInfo<Evaluation> pageInfo=new PageInfo<>(evaluationArrayList);
        return pageInfo;
    }
    @RequestMapping("/admin/deleteEva")
    public JsonResult<Void> update(String film_id,String user_id){

        if (evaluationService.deleteEva(film_id,user_id)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
}
