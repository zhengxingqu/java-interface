package com.example.demo.Dao;

import com.example.demo.Model.Plugin;

public interface PluginMapper {
    int insert(Plugin record);

    int insertSelective(Plugin record);
}