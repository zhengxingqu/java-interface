package com.example.demo.Dao;

import com.example.demo.Model.UserSummaryByStagesWithBLOBs;

public interface UserSummaryByStagesMapper {
    int insert(UserSummaryByStagesWithBLOBs record);

    int insertSelective(UserSummaryByStagesWithBLOBs record);
}