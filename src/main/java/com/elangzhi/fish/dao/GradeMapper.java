package com.elangzhi.fish.dao;

import com.elangzhi.fish.model.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(Grade record);

    Long insertSelective(Grade record);

    Grade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    List<Grade> findInfo1(@Param("gameId") Long gameId,@Param("chang") Integer chang,@Param("qu") Integer qu);

    List<Grade> listByGame(Long id);

    List<Grade> countQu(Long id);

    List<Grade> findByGameChangPerson(@Param("gameId") Long gameId,@Param("chang") Integer chang, @Param("personId")Long personId);

    List<Grade> gradeShow(@Param("gameId") Long gameId,@Param("chang") Integer chang,@Param("qu") Integer qu);

    List<Grade> jifen(@Param("gameId") Long gameId,@Param("chang") Integer chang);

    List<Grade> zongfenShow(@Param("gameId") Long gameId);

    List<Grade> findByChangNumber(@Param("gameId") Long gameId,@Param("chang") Integer chang,@Param("personId")  Long personId);

    List<Grade> groupShow(@Param("gameId") Long gameId,@Param("chang") Integer chang,@Param("qu") Integer qu);
}