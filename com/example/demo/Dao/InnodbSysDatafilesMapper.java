package com.example.demo.Dao;

import com.example.demo.Model.InnodbSysDatafiles;

public interface InnodbSysDatafilesMapper {
    int insert(InnodbSysDatafiles record);

    int insertSelective(InnodbSysDatafiles record);
}