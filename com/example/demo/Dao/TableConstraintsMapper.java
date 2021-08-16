package com.example.demo.Dao;

import com.example.demo.Model.TableConstraints;

public interface TableConstraintsMapper {
    int insert(TableConstraints record);

    int insertSelective(TableConstraints record);
}