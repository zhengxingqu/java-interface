package com.example.demo.Dao;

import com.example.demo.Model.UserSummaryByStatementTypeWithBLOBs;

public interface UserSummaryByStatementTypeMapper {
    int insert(UserSummaryByStatementTypeWithBLOBs record);

    int insertSelective(UserSummaryByStatementTypeWithBLOBs record);
}