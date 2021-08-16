package com.example.demo.Dao;

import com.example.demo.Model.DjangoAdminLogWithBLOBs;

public interface DjangoAdminLogMapper {
    int insert(DjangoAdminLogWithBLOBs record);

    int insertSelective(DjangoAdminLogWithBLOBs record);
}