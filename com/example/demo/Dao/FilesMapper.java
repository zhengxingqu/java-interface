package com.example.demo.Dao;

import com.example.demo.Model.Files;

public interface FilesMapper {
    int insert(Files record);

    int insertSelective(Files record);
}