package com.example.demo.Dao;

import com.example.demo.Model.HelpRelation;

public interface HelpRelationMapper {
    int insert(HelpRelation record);

    int insertSelective(HelpRelation record);
}