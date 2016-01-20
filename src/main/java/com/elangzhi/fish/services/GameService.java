package com.elangzhi.fish.services;

import com.elangzhi.fish.model.Game;

import java.util.List;

/**
 * Created by GaoXiang on 2016/1/7 0007.
 */
public interface GameService extends BaseService<Game> {

    /**
     * 根据时间获取最新的比赛
     * @return
     */
    Game findNew();
}
