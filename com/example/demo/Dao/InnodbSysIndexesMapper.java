package com.example.demo.Dao;

import com.example.demo.Model.InnodbSysIndexes;

public interface InnodbSysIndexesMapper {
    int insert(InnodbSysIndexes record);

    int insertSelective(InnodbSysIndexes record);
}