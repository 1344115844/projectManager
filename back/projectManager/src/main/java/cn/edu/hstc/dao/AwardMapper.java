package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Award;

import java.util.ArrayList;

public interface AwardMapper {
    int deleteByPrimaryKey(Integer awardId);

    int insert(Award record);

    int insertSelective(Award record);

    Award selectByPrimaryKey(Integer awardId);

    int updateByPrimaryKeySelective(Award record);

    int updateByPrimaryKey(Award record);

    ArrayList<Award> selectByUserId(Integer user_id);//查询用户拥有的获奖信息

    Integer getAwardCountByUserId(Integer user_id);//查询获奖信息数目

}