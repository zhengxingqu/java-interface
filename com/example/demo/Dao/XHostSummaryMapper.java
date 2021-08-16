package com.example.demo.Dao;

import com.example.demo.Model.XHostSummary;

public interface XHostSummaryMapper {
    int insert(XHostSummary record);

    int insertSelective(XHostSummary record);
}