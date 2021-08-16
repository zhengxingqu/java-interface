package com.example.demo.Dao;

import com.example.demo.Model.HostSummaryByStatementLatencyWithBLOBs;

public interface HostSummaryByStatementLatencyMapper {
    int insert(HostSummaryByStatementLatencyWithBLOBs record);

    int insertSelective(HostSummaryByStatementLatencyWithBLOBs record);
}