package com.example.demo.Dao;

import com.example.demo.Model.HostSummaryByStagesWithBLOBs;

public interface HostSummaryByStagesMapper {
    int insert(HostSummaryByStagesWithBLOBs record);

    int insertSelective(HostSummaryByStagesWithBLOBs record);
}