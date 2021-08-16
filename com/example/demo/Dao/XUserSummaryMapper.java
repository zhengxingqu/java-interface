package com.example.demo.Dao;

import com.example.demo.Model.XUserSummary;

public interface XUserSummaryMapper {
    int insert(XUserSummary record);

    int insertSelective(XUserSummary record);
}