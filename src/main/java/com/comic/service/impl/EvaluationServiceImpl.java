package com.comic.service.impl;

import com.comic.dao.EvaluationDao;
import com.comic.model.Evaluation;
import com.comic.service.EvaluationService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    EvaluationDao evaluationDao;
    @Override
    public List<Evaluation> selectEvaByPage(int start, int size) {
        PageHelper.startPage(start,size);
        return evaluationDao.selectEvaByPage();
    }

    @Override
    public boolean addeva(Evaluation evaluation) {

        return evaluationDao.addeva(evaluation)==1?true:false;
    }

    @Override
    public List<Evaluation> selecteva(String film_id) {
        return evaluationDao.selecteva(film_id);
    }

    @Override
    public boolean deleteEva(String film_id, String user_id) {
        return evaluationDao.deleteEva(film_id,user_id)==1?true:false;
    }

    @Override
    public List<Evaluation> searchEva(String search, int start, int size) {
        search='%'+search+'%';
        PageHelper.startPage(start,size);
        return evaluationDao.searchEva(search);
    }
}
