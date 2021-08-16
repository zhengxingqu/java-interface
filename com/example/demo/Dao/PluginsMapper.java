package com.example.demo.Dao;

import com.example.demo.Model.Plugins;

public interface PluginsMapper {
    int insert(Plugins record);

    int insertSelective(Plugins record);
}