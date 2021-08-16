package com.example.demo.Dao;

import com.example.demo.Model.Hosts;

public interface HostsMapper {
    int insert(Hosts record);

    int insertSelective(Hosts record);
}