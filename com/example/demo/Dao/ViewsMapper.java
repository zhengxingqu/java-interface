package com.example.demo.Dao;

import com.example.demo.Model.Views;

public interface ViewsMapper {
    int insert(Views record);

    int insertSelective(Views record);
}