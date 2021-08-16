package com.example.demo.Dao;

import com.example.demo.Model.AuthtokenToken;

public interface AuthtokenTokenMapper {
    int insert(AuthtokenToken record);

    int insertSelective(AuthtokenToken record);
}