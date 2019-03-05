package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2018/8/9 18:01
 * @Description:
 */
public interface UserService {
    List<User> getUserList();

    User findUserById(long id);

    void save(User user);

    void update(User user);

    void delete(long id);
}
