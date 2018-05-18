package com.ssm.demo.dao;

import com.ssm.demo.mapper.UserMapper;
import com.ssm.demo.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by renwujie on 2018/05/17 at 21:05
 */
@Repository
public class UserDaoImpl implements IUserDao {
    private UserMapper userMapper;

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
