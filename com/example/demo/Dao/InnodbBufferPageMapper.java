package com.example.demo.Dao;

import com.example.demo.Model.InnodbBufferPage;

public interface InnodbBufferPageMapper {
    int insert(InnodbBufferPage record);

    int insertSelective(InnodbBufferPage record);
}