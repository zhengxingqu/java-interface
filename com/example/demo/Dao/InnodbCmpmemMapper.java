package com.example.demo.Dao;

import com.example.demo.Model.InnodbCmpmem;

public interface InnodbCmpmemMapper {
    int insert(InnodbCmpmem record);

    int insertSelective(InnodbCmpmem record);
}