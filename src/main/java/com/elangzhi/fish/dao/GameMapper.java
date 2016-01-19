package com.elangzhi.fish.dao;

import com.elangzhi.fish.model.Game;

public interface GameMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(Game record);

    Long insertSelective(Game record);

    Game selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);
}