package com.example.demo.Dao;

import com.example.demo.Model.InnodbBufferPageLru;

public interface InnodbBufferPageLruMapper {
    int insert(InnodbBufferPageLru record);

    int insertSelective(InnodbBufferPageLru record);
}