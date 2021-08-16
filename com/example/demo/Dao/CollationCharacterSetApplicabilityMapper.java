package com.example.demo.Dao;

import com.example.demo.Model.CollationCharacterSetApplicability;

public interface CollationCharacterSetApplicabilityMapper {
    int insert(CollationCharacterSetApplicability record);

    int insertSelective(CollationCharacterSetApplicability record);
}