package com.example.demo.Dao;

import com.example.demo.Model.UserSummaryByFileIoTypeWithBLOBs;

public interface UserSummaryByFileIoTypeMapper {
    int insert(UserSummaryByFileIoTypeWithBLOBs record);

    int insertSelective(UserSummaryByFileIoTypeWithBLOBs record);
}