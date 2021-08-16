package com.example.demo.Dao;

import com.example.demo.Model.SessionWithBLOBs;

public interface SessionMapper {
    int insert(SessionWithBLOBs record);

    int insertSelective(SessionWithBLOBs record);
}