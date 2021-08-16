package com.example.demo.Dao;

import com.example.demo.Model.Servers;

public interface ServersMapper {
    int insert(Servers record);

    int insertSelective(Servers record);
}