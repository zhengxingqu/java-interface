package com.example.demo.Dao;

import com.example.demo.Model.InnodbCmp;

public interface InnodbCmpMapper {
    int insert(InnodbCmp record);

    int insertSelective(InnodbCmp record);
}