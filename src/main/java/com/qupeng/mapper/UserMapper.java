package com.qupeng.mapper;

import com.qupeng.sample2.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}