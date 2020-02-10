package com.qupeng.component;

import com.qupeng.service.BaseServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class CacheTemplete {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void initRedisTemplate () {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
    }

    public <T> T loadCache(String key, long expire, BaseServiceHandler<T> service) {
        //避免缓存击穿的代码实现
        T result = (T)redisTemplate.opsForValue().get(key);
        if (null == result) {
            synchronized (this) {
                result = (T)redisTemplate.opsForValue().get(key);
                if (null == result) {
                    //查询数据库
                    result = service.loadData();
                    redisTemplate.opsForValue().set(key, result, expire, TimeUnit.MINUTES);
                }
            }
        }
        return result;
    }
}
