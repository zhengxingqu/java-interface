package com.example.demo.Dao;

import com.example.demo.Model.InnodbMetrics;

public interface InnodbMetricsMapper {
    int insert(InnodbMetrics record);

    int insertSelective(InnodbMetrics record);
}