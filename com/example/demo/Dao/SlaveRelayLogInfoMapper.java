package com.example.demo.Dao;

import com.example.demo.Model.SlaveRelayLogInfoWithBLOBs;

public interface SlaveRelayLogInfoMapper {
    int insert(SlaveRelayLogInfoWithBLOBs record);

    int insertSelective(SlaveRelayLogInfoWithBLOBs record);
}