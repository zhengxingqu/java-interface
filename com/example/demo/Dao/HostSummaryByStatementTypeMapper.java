package com.example.demo.Dao;

import com.example.demo.Model.HostSummaryByStatementTypeWithBLOBs;

public interface HostSummaryByStatementTypeMapper {
    int insert(HostSummaryByStatementTypeWithBLOBs record);

    int insertSelective(HostSummaryByStatementTypeWithBLOBs record);
}