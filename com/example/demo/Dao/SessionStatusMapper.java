package com.example.demo.Dao;

import com.example.demo.Model.SessionStatus;

public interface SessionStatusMapper {
    int insert(SessionStatus record);

    int insertSelective(SessionStatus record);
}