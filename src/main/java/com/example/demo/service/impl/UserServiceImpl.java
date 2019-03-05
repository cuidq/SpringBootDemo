package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2018/8/9 18:04
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User findUserById(long id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(long id) {

    }
}
