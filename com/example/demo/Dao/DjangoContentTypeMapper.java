package com.example.demo.Dao;

import com.example.demo.Model.DjangoContentType;

public interface DjangoContentTypeMapper {
    int insert(DjangoContentType record);

    int insertSelective(DjangoContentType record);
}