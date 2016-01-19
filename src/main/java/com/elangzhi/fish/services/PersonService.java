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
}
