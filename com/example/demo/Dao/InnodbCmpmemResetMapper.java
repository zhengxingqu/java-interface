package com.example.demo.Dao;

import com.example.demo.Model.InnodbCmpmemReset;

public interface InnodbCmpmemResetMapper {
    int insert(InnodbCmpmemReset record);

    int insertSelective(InnodbCmpmemReset record);
}