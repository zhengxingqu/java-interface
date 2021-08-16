package com.example.demo.Dao;

import com.example.demo.Model.HelpKeyword;

public interface HelpKeywordMapper {
    int insert(HelpKeyword record);

    int insertSelective(HelpKeyword record);
}