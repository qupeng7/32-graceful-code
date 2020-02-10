package com.qupeng.service.impl;

import com.qupeng.constant.Constants;
import com.qupeng.mapper.GoodsMapper;
import com.qupeng.sample2.Goods;
import com.qupeng.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods getGoodsById(Integer id) {
        //避免缓存击穿的代码实现
        Goods goods = (Goods)redisTemplate.opsForValue().get(Constants.USER_KEY + id);
        if (null != goods) {
            synchronized (this) {
                goods = (Goods)redisTemplate.opsForValue().get(Constants.USER_KEY + id);
                if (null != goods) {
                    goods = goodsMapper.selectByPrimaryKey(id);
                    redisTemplate.opsForValue().set(Constants.USER_KEY + id, goods);
                }
            }
        }
        return goods;
    }
}
