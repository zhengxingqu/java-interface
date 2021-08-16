package com.example.demo.Dao;

import com.example.demo.Model.HostSummaryByFileIo;

public interface HostSummaryByFileIoMapper {
    int insert(HostSummaryByFileIo record);

    int insertSelective(HostSummaryByFileIo record);
}