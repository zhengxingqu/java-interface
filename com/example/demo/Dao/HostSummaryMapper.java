package com.example.demo.Dao;

import com.example.demo.Model.HostSummaryWithBLOBs;

public interface HostSummaryMapper {
    int insert(HostSummaryWithBLOBs record);

    int insertSelective(HostSummaryWithBLOBs record);
}