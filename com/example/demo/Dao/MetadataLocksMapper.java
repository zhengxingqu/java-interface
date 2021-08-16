package com.example.demo.Dao;

import com.example.demo.Model.MetadataLocks;

public interface MetadataLocksMapper {
    int insert(MetadataLocks record);

    int insertSelective(MetadataLocks record);
}