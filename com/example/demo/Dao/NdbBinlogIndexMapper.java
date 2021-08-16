package com.example.demo.Dao;

import com.example.demo.Model.NdbBinlogIndex;

public interface NdbBinlogIndexMapper {
    int insert(NdbBinlogIndex record);

    int insertSelective(NdbBinlogIndex record);
}