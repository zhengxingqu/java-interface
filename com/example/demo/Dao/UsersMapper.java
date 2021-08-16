package com.example.demo.Dao;

import com.example.demo.Model.Users;

public interface UsersMapper {
    int insert(Users record);

    int insertSelective(Users record);
}