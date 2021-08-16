package com.example.demo.Dao;

import com.example.demo.Model.HostCache;

public interface HostCacheMapper {
    int insert(HostCache record);

    int insertSelective(HostCache record);
}