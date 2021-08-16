package com.example.demo.Dao;

import com.example.demo.Model.PsCheckLostInstrumentation;

public interface PsCheckLostInstrumentationMapper {
    int insert(PsCheckLostInstrumentation record);

    int insertSelective(PsCheckLostInstrumentation record);
}