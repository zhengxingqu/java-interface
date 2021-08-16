package com.example.demo.Dao;

import com.example.demo.Model.ProcWithBLOBs;

public interface ProcMapper {
    int insert(ProcWithBLOBs record);

    int insertSelective(ProcWithBLOBs record);
}