package com.example.demo.Dao;

import com.example.demo.Model.TableHandles;

public interface TableHandlesMapper {
    int insert(TableHandles record);

    int insertSelective(TableHandles record);
}