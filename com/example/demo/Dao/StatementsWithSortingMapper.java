package com.example.demo.Dao;

import com.example.demo.Model.StatementsWithSortingWithBLOBs;

public interface StatementsWithSortingMapper {
    int insert(StatementsWithSortingWithBLOBs record);

    int insertSelective(StatementsWithSortingWithBLOBs record);
}