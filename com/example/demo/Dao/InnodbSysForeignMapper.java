package com.example.demo.Dao;

import com.example.demo.Model.InnodbSysForeign;

public interface InnodbSysForeignMapper {
    int insert(InnodbSysForeign record);

    int insertSelective(InnodbSysForeign record);
}