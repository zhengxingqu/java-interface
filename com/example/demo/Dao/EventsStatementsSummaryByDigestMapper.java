package com.example.demo.Dao;

import com.example.demo.Model.EventsStatementsSummaryByDigest;

public interface EventsStatementsSummaryByDigestMapper {
    int insert(EventsStatementsSummaryByDigest record);

    int insertSelective(EventsStatementsSummaryByDigest record);
}