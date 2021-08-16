package com.example.demo.Dao;

import com.example.demo.Model.PreparedStatementsInstances;

public interface PreparedStatementsInstancesMapper {
    int insert(PreparedStatementsInstances record);

    int insertSelective(PreparedStatementsInstances record);
}