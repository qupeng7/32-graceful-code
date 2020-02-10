package com.qupeng.service.impl;

import com.qupeng.component.CacheTemplete;
import com.qupeng.constant.Constants;
import com.qupeng.mapper.UserMapper;
import com.qupeng.sample2.User;
import com.qupeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheTemplete cacheTemplete;

    /**
     * 原版的
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) {
        //避免缓存击穿的代码实现
        User user = (User)redisTemplate.opsForValue().get(Constants.USER_KEY + id);
        if (null == user) {
            synchronized (this) {
                user = (User)redisTemplate.opsForValue().get(Constants.USER_KEY + id);
                if (null == user) {
                    user = userMapper.selectByPrimaryKey(id);
                    redisTemplate.opsForValue().set(Constants.USER_KEY + id, user);
                }
            }
        }
        return user;
    }

    /**
     * 模板方法模式实现
     *
     */
    public User getUserByIdTemplate(Integer id) {
        //避免缓存击穿的代码实现
        User user = cacheTemplete.loadCache(Constants.USER_KEY + id, 10, () -> {
            System.out.println("查询了数据库");
            return userMapper.selectByPrimaryKey(id);
        });
        return user;
    }
}