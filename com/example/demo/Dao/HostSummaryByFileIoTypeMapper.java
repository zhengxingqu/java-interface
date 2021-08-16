package com.example.demo.Dao;

import com.example.demo.Model.HostSummaryByFileIoTypeWithBLOBs;

public interface HostSummaryByFileIoTypeMapper {
    int insert(HostSummaryByFileIoTypeWithBLOBs record);

    int insertSelective(HostSummaryByFileIoTypeWithBLOBs record);
}