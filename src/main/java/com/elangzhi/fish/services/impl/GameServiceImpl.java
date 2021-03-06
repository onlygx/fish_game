package com.elangzhi.fish.services.impl;

import com.elangzhi.fish.dao.GameMapper;
import com.elangzhi.fish.model.Game;
import com.elangzhi.fish.services.GameService;
import com.elangzhi.fish.services.PersonService;
import com.elangzhi.fish.tools.UUIDFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by GaoXiang on 2016/1/7 0007.
 */
@Service("gameService")
public class GameServiceImpl implements GameService {

    @Resource
    GameMapper gameMapper;

    @Resource
    PersonService personService;


    @Override
    public Long save(Game game) {
        game.setId(UUIDFactory.getLongId());
        game.setTime(new Date());
        return gameMapper.insertSelective(game);
    }

    @Override
    public Integer deleteById(Long id) {
        return gameMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Game findById(Long id) {
        return gameMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateById(Game game) {
        return gameMapper.updateByPrimaryKeySelective(game);
    }


    @Override
    public Game findNew() {
        List<Game> list = gameMapper.list();
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
