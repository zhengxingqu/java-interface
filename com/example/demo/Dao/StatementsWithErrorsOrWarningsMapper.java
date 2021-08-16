package com.example.demo.Dao;

import com.example.demo.Model.StatementsWithErrorsOrWarnings;

public interface StatementsWithErrorsOrWarningsMapper {
    int insert(StatementsWithErrorsOrWarnings record);

    int insertSelective(StatementsWithErrorsOrWarnings record);
}