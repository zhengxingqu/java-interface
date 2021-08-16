package com.example.demo.Dao;

import com.example.demo.Model.TableLockWaitsSummaryByTable;

public interface TableLockWaitsSummaryByTableMapper {
    int insert(TableLockWaitsSummaryByTable record);

    int insertSelective(TableLockWaitsSummaryByTable record);
}