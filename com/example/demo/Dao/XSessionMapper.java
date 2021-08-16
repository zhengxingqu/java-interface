package com.example.demo.Dao;

import com.example.demo.Model.XSessionWithBLOBs;

public interface XSessionMapper {
    int insert(XSessionWithBLOBs record);

    int insertSelective(XSessionWithBLOBs record);
}