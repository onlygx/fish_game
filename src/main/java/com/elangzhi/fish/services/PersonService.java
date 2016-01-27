package com.elangzhi.fish.services;

import com.elangzhi.fish.model.Person;

import java.util.List;

/**
 * Created by GaoXiang on 2016/1/7 0007.
 */
public interface PersonService extends BaseService<Person> {


    /**
     * 获取所有参赛人员
     * @param gameId
     * @return
     */
    List<Person> listByGame(Long gameId);

    /**
     * 排除某个分类获取全部
     * @param type
     * @return
     */
    List<Person> listExcludePersonTypeByGame(Long gameId,Integer type);

    /**
     * 获取某个分类所有人员
     * @param id
     * @param i
     * @return
     */
    List<Person> listByGameType(Long id, int i);

    /**
     * 获取最新的number
     * @return
     * @param gameId
     */
    Person findNewNumber(Long gameId);
}
