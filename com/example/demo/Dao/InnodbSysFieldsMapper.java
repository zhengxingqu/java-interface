package com.example.demo.Dao;

import com.example.demo.Model.InnodbSysFields;

public interface InnodbSysFieldsMapper {
    int insert(InnodbSysFields record);

    int insertSelective(InnodbSysFields record);
}