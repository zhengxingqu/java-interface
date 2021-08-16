package com.example.demo.Dao;

import com.example.demo.Model.InnodbSysForeignCols;

public interface InnodbSysForeignColsMapper {
    int insert(InnodbSysForeignCols record);

    int insertSelective(InnodbSysForeignCols record);
}