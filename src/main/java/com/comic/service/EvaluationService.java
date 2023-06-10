package com.comic.service;

import com.comic.model.Evaluation;

import java.util.Date;
import java.util.List;

public interface EvaluationService {
    List<Evaluation> selectEvaByPage(int start, int size);
    List<Evaluation> selecteva(String film_id);
    boolean addeva(Evaluation evaluation);
    boolean deleteEva(String film_id, String user_id);
    List<Evaluation> searchEva(String search, int start, int size);
}
