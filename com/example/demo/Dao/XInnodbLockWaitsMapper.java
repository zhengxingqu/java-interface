package com.example.demo.Dao;

import com.example.demo.Model.XInnodbLockWaits;

public interface XInnodbLockWaitsMapper {
    int insert(XInnodbLockWaits record);

    int insertSelective(XInnodbLockWaits record);
}