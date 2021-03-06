package com.qupeng.mapper;

import com.qupeng.sample2.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

	int updateByPrimaryKeyStore(Integer id);

}