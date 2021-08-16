package com.example.demo.Dao;

import com.example.demo.Model.InnodbSysColumns;

public interface InnodbSysColumnsMapper {
    int insert(InnodbSysColumns record);

    int insertSelective(InnodbSysColumns record);
}