package com.example.demo.Dao;

import com.example.demo.Model.FileSummaryByEventName;

public interface FileSummaryByEventNameMapper {
    int insert(FileSummaryByEventName record);

    int insertSelective(FileSummaryByEventName record);
}