package com.example.demo.Dao;

import com.example.demo.Model.InnodbSysTablestats;

public interface InnodbSysTablestatsMapper {
    int insert(InnodbSysTablestats record);

    int insertSelective(InnodbSysTablestats record);
}