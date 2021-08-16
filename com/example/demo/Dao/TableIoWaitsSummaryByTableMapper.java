package com.example.demo.Dao;

import com.example.demo.Model.TableIoWaitsSummaryByTable;

public interface TableIoWaitsSummaryByTableMapper {
    int insert(TableIoWaitsSummaryByTable record);

    int insertSelective(TableIoWaitsSummaryByTable record);
}