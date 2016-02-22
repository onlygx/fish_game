package com.elangzhi.fish.services.impl;

import com.elangzhi.fish.dao.GradeMapper;
import com.elangzhi.fish.model.Grade;
import com.elangzhi.fish.services.GradeService;
import com.elangzhi.fish.tools.UUIDFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by GaoXiang on 2016/1/7 0007.
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {

    @Resource
    GradeMapper gradeMapper;

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
}
