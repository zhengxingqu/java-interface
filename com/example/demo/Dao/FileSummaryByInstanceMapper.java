package com.example.demo.Dao;

import com.example.demo.Model.FileSummaryByInstance;

public interface FileSummaryByInstanceMapper {
    int insert(FileSummaryByInstance record);

    int insertSelective(FileSummaryByInstance record);
}