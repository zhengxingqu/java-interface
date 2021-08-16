package com.example.demo.Dao;

import com.example.demo.Model.XLatestFileIo;

public interface XLatestFileIoMapper {
    int insert(XLatestFileIo record);

    int insertSelective(XLatestFileIo record);
}