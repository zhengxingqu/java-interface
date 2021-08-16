package com.example.demo.Dao;

import com.example.demo.Model.InnodbCmpPerIndex;

public interface InnodbCmpPerIndexMapper {
    int insert(InnodbCmpPerIndex record);

    int insertSelective(InnodbCmpPerIndex record);
}