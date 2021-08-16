package com.example.demo.Dao;

import com.example.demo.Model.UserSummaryByStatementLatencyWithBLOBs;

public interface UserSummaryByStatementLatencyMapper {
    int insert(UserSummaryByStatementLatencyWithBLOBs record);

    int insertSelective(UserSummaryByStatementLatencyWithBLOBs record);
}