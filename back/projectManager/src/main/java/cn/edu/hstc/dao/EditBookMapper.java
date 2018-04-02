package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.EditBook;

import java.util.ArrayList;

public interface EditBookMapper {
    int deleteByPrimaryKey(Integer editId);

    int insert(EditBook record);

    int insertSelective(EditBook record);

    EditBook selectByPrimaryKey(Integer editId);

    int updateByPrimaryKeySelective(EditBook record);

    int updateByPrimaryKey(EditBook record);

    ArrayList<EditBook> selectByUserId(Integer user_id);//查询用户拥有的参与教材

    Integer getEditBookCountByUserId(Integer user_id);//查询参与教材数目
}