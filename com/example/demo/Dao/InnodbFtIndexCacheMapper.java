package com.example.demo.Dao;

import com.example.demo.Model.InnodbFtIndexCache;

public interface InnodbFtIndexCacheMapper {
    int insert(InnodbFtIndexCache record);

    int insertSelective(InnodbFtIndexCache record);
}