package com.example.demo.Dao;

import com.example.demo.Model.SessionSslStatus;

public interface SessionSslStatusMapper {
    int insert(SessionSslStatus record);

    int insertSelective(SessionSslStatus record);
}