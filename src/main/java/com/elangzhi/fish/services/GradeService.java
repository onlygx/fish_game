package com.elangzhi.fish.services;

import com.elangzhi.fish.model.Grade;

import java.util.List;

/**
 * Created by GaoXiang on 2016/1/7 0007.
 */
public interface GradeService extends BaseService<Grade> {

    List<Grade> findInfo1(Long gameId,Integer chang,Integer qu);

    List<Grade> listByGame(Long id);

    List<Grade> countQu(Long id);


    Grade findByGameChangPerson(Long gameId, Integer chang, Long personId);
}
