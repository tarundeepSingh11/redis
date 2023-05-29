package com.RedisWithSpring.redisCode.dao;

import com.RedisWithSpring.redisCode.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisDao {
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY="USER";

    public boolean saveUser(User user) {
        try{
            redisTemplate.opsForHash().put(KEY,user.getId().toString(),user);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public List<User> getAllUser() {
        List<User> users;
        users=redisTemplate.opsForHash().values(KEY);
        return users;
    }
}
