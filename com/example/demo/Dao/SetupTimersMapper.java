package com.example.demo.Dao;

import com.example.demo.Model.SetupTimers;

public interface SetupTimersMapper {
    int insert(SetupTimers record);

    int insertSelective(SetupTimers record);
}