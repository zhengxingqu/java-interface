package com.example.demo.Dao;

import com.example.demo.Model.XWaitsByHostByLatency;

public interface XWaitsByHostByLatencyMapper {
    int insert(XWaitsByHostByLatency record);

    int insertSelective(XWaitsByHostByLatency record);
}