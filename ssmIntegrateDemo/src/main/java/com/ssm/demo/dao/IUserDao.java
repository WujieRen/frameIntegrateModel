package com.ssm.demo.dao;

import com.ssm.demo.model.User;

import java.util.List;

/**
 * Created by renwujie on 2018/05/17 at 21:04
 */
public interface IUserDao {
    public List<User> getUserList();
}
