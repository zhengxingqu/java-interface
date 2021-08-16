package com.example.demo.Dao;

import com.example.demo.Model.CharacterSets;

public interface CharacterSetsMapper {
    int insert(CharacterSets record);

    int insertSelective(CharacterSets record);
}