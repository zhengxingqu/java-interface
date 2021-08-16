package com.example.demo.Dao;

import com.example.demo.Model.InnodbCmpReset;

public interface InnodbCmpResetMapper {
    int insert(InnodbCmpReset record);

    int insertSelective(InnodbCmpReset record);
}