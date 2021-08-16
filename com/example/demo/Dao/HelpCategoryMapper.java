package com.example.demo.Dao;

import com.example.demo.Model.HelpCategory;

public interface HelpCategoryMapper {
    int insert(HelpCategory record);

    int insertSelective(HelpCategory record);
}