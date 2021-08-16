package com.example.demo.Dao;

import com.example.demo.Model.HelpTopicWithBLOBs;

public interface HelpTopicMapper {
    int insert(HelpTopicWithBLOBs record);

    int insertSelective(HelpTopicWithBLOBs record);
}