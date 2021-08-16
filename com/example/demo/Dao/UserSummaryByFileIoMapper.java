package com.example.demo.Dao;

import com.example.demo.Model.UserSummaryByFileIo;

public interface UserSummaryByFileIoMapper {
    int insert(UserSummaryByFileIo record);

    int insertSelective(UserSummaryByFileIo record);
}