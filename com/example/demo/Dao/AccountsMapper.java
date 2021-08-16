package com.example.demo.Dao;

import com.example.demo.Model.Accounts;

public interface AccountsMapper {
    int insert(Accounts record);

    int insertSelective(Accounts record);
}