package com.elangzhi.fish.services.impl;

import com.elangzhi.fish.dao.GameMapper;
import com.elangzhi.fish.dao.GradeMapper;
import com.elangzhi.fish.model.Game;
import com.elangzhi.fish.model.Grade;
import com.elangzhi.fish.services.GradeService;
import com.elangzhi.fish.tools.UUIDFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by GaoXiang on 2016/1/7 0007.
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {

    @Resource
    GradeMapper gradeMapper;

    @Resource
    GameMapper gameMapper;

    @Override
    public Long save(Grade grade) {
        grade.setId(UUIDFactory.getLongId());
        grade.setTime(new Date());
        return gradeMapper.insertSelective(grade);
    }

    @Override
    public Integer deleteById(Long id) {
        return gradeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Grade findById(Long id) {
        return gradeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateById(Grade grade) {
        return gradeMapper.updateByPrimaryKeySelective(grade);
    }


    @Override
    public List<Grade> findInfo1(Long gameId, Integer chang, Integer qu) {
        return gradeMapper.findInfo1(gameId,chang,qu);
    }

    @Override
    public List<Grade> listByGame(Long id) {
        return gradeMapper.listByGame(id);
    }

    @Override
    public List<Grade> countQu(Long id) {
        return gradeMapper.countQu(id);
    }

    @Override
    public Grade findByGameChangPerson(Long gameId, Integer chang, Long personId) {
        List<Grade> list = gradeMapper.findByGameChangPerson(gameId, chang,personId);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Grade> gradeShow(Long gameId, Integer chang, Integer qu) {
        return gradeMapper.gradeShow(gameId,chang,qu);
    }

    @Override
    public List<Grade> jifen(Long gameId,Integer chang,Integer qu) {
        return gradeMapper.jifen(gameId,chang,qu);
    }

    @Override
    public Grade findByChangNumber(Long gameId,Integer chang, Long personId) {
        List<Grade> gradeList = gradeMapper.findByChangNumber(gameId,chang,personId);
        if(gradeList.size() > 0){
            return gradeList.get(0);
        }
        return null;
    }

    @Override
    public List<Grade> zongfenShow(Long gameId) {
        Game game = gameMapper.selectByPrimaryKey(gameId);
        List<Grade> list = gradeMapper.zongfenShow(gameId);
        for(Grade g : list){
            g.setChild(new ArrayList<>());
            for(int i = 1;i<=game.getChang();i++){
                List<Grade> gradeList = gradeMapper.findByGameChangPerson(gameId,i,g.getPersonId());
                if(gradeList.size() > 0){
                    g.getChild().add(gradeList.get(0));
                }else{
                    g.getChild().add(new Grade());
                }
            }
        }
        return list;
    }

    @Override
    public List<Grade> groupShow(Long gameId, Integer chang, Integer qu) {
        return gradeMapper.groupShow(gameId,chang,qu);
    }
}
