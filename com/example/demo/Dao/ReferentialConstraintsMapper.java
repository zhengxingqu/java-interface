package com.example.demo.Dao;

import com.example.demo.Model.ReferentialConstraints;

public interface ReferentialConstraintsMapper {
    int insert(ReferentialConstraints record);

    int insertSelective(ReferentialConstraints record);
}