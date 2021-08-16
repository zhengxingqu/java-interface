package com.example.demo.service;

import com.example.demo.model.User;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserService {
    Page<User> findAllUser(int page, int size);

    User findUserById(int id);

    void updateUser(User user);

    void insertUser(User user) throws Exception;

    void deleteUser(int id);

    Page<User> findSearchPage(Integer page, Integer size, User user);

    List findUser(String email);
}
