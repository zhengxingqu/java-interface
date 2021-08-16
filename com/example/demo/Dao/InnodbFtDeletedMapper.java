package com.example.demo.Dao;

import com.example.demo.Model.InnodbFtDeleted;

public interface InnodbFtDeletedMapper {
    int insert(InnodbFtDeleted record);

    int insertSelective(InnodbFtDeleted record);
}