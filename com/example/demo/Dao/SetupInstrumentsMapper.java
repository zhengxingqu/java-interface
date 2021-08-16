package com.example.demo.Dao;

import com.example.demo.Model.SetupInstruments;

public interface SetupInstrumentsMapper {
    int insert(SetupInstruments record);

    int insertSelective(SetupInstruments record);
}