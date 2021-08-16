package com.example.demo.Dao;

import com.example.demo.Model.InnodbSysTablespaces;

public interface InnodbSysTablespacesMapper {
    int insert(InnodbSysTablespaces record);

    int insertSelective(InnodbSysTablespaces record);
}