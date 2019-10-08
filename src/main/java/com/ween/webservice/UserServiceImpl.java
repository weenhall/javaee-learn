package com.ween.webservice;

/**
 * Created by wen on 2018/4/8
 */
public class UserServiceImpl implements UserService {
    public User getUser(String name) {
        User user=new User();
        user.setUsername(name);
        user.setPassword(name);
        return user;
    }
}
