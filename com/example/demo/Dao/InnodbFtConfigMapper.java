package com.example.demo.Dao;

import com.example.demo.Model.InnodbFtConfig;

public interface InnodbFtConfigMapper {
    int insert(InnodbFtConfig record);

    int insertSelective(InnodbFtConfig record);
}