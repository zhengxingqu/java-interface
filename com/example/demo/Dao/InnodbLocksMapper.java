package com.example.demo.Dao;

import com.example.demo.Model.InnodbLocks;

public interface InnodbLocksMapper {
    int insert(InnodbLocks record);

    int insertSelective(InnodbLocks record);
}