package com.example.demo.Dao;

import com.example.demo.Model.InnodbTrx;

public interface InnodbTrxMapper {
    int insert(InnodbTrx record);

    int insertSelective(InnodbTrx record);
}