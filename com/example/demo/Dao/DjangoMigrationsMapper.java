package com.example.demo.Dao;

import com.example.demo.Model.DjangoMigrations;

public interface DjangoMigrationsMapper {
    int insert(DjangoMigrations record);

    int insertSelective(DjangoMigrations record);
}