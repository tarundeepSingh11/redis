package com.RedisWithSpring.redisCode.sevice;

import com.RedisWithSpring.redisCode.dao.RedisDao;
import com.RedisWithSpring.redisCode.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisDao redisDao;

    @Override
    public boolean saveUser(User user){
        return redisDao.saveUser(user);
    }

    @Override
    public List<User> getALlUser() {
        return  redisDao.getAllUser();    }

}
