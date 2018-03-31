package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.EditBook;

public interface EditBookMapper {
    int deleteByPrimaryKey(Integer editId);

    int insert(EditBook record);

    int insertSelective(EditBook record);

    EditBook selectByPrimaryKey(Integer editId);

    int updateByPrimaryKeySelective(EditBook record);

    int updateByPrimaryKey(EditBook record);
}