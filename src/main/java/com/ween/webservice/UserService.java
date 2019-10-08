package com.ween.webservice;

import javax.jws.WebService;

/**
 * Created by wen on 2018/4/8
 */
@WebService
public interface UserService {
    public User getUser(String name);
;}
