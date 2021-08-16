package com.example.demo.Dao;

import com.example.demo.Model.XStatementsWithErrorsOrWarnings;

public interface XStatementsWithErrorsOrWarningsMapper {
    int insert(XStatementsWithErrorsOrWarnings record);

    int insertSelective(XStatementsWithErrorsOrWarnings record);
}