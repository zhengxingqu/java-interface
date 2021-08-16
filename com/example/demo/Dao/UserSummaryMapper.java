package com.example.demo.Dao;

import com.example.demo.Model.UserSummaryWithBLOBs;

public interface UserSummaryMapper {
    int insert(UserSummaryWithBLOBs record);

    int insertSelective(UserSummaryWithBLOBs record);
}