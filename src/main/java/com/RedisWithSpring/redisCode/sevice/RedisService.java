package com.RedisWithSpring.redisCode.sevice;

import com.RedisWithSpring.redisCode.modal.User;

import java.util.List;

public interface RedisService {
    boolean saveUser(User user);

    List<User> getALlUser();
}
