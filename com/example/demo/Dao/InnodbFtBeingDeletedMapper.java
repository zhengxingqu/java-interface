package com.example.demo.Dao;

import com.example.demo.Model.InnodbFtBeingDeleted;

public interface InnodbFtBeingDeletedMapper {
    int insert(InnodbFtBeingDeleted record);

    int insertSelective(InnodbFtBeingDeleted record);
}