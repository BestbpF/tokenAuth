package com.bpf.tokenAuth.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClient {
    
    public static final long TOKEN_EXPIRES_SECOND = 1800;

    @Autowired
    private StringRedisTemplate redisTpl;
    
    /**
     * 向redis中设值
     * @param key 使用 a:b:id的形式在使用rdm进行查看redis情况时会看到分层文件夹的展示形式，便于管理
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        boolean result = false;
        try {
            redisTpl.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    /**
     * 向redis中设置，同时设置过期时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key, String value, long time) {
        boolean result = false;
        try {
            redisTpl.opsForValue().set(key, value);
            expire(key, time);
            result =  true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 获取redis中的值
     * @param key
     * @return
     */
    public String get(String key) {
        String result = null;
        try {
            result = redisTpl.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
  
    }
    
    /**
     * 设置key的过期时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        boolean result = false;
        try {
            if(time > 0) {
                redisTpl.expire(key, time, TimeUnit.SECONDS);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 根据key删除对应value
     * @param key
     * @return
     */
    public boolean remove(String key) {
        boolean result = false;
        try {
            redisTpl.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    
    
}
