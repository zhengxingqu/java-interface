package com.example.demo.Dao;

import com.example.demo.Model.Version;

public interface VersionMapper {
    int insert(Version record);

    int insertSelective(Version record);
}