package com.elangzhi.fish.dao;

import com.elangzhi.fish.model.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(Person record);

    Long insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Person> listByGame(@Param("gameId") Long gameId);

    List<Person> listExcludePersonTypeByGame(@Param("gameId") Long gameId,@Param("type") Integer type);

    List<Person> listByGameType(@Param("gameId") Long gameId,@Param("type") Integer type);

    Person findNewNumber(Long gameId);
}