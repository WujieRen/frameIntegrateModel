package com.ssm.demo.service;

import com.ssm.demo.dao.IUserDao;
import com.ssm.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by renwujie on 2018/05/17 at 21:11
 */
@Service
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    @Resource
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findUser() {
        return userDao.getUserList();
    }
}
