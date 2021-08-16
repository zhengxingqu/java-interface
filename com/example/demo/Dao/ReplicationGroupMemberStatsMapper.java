package com.example.demo.Dao;

import com.example.demo.Model.ReplicationGroupMemberStatsWithBLOBs;

public interface ReplicationGroupMemberStatsMapper {
    int insert(ReplicationGroupMemberStatsWithBLOBs record);

    int insertSelective(ReplicationGroupMemberStatsWithBLOBs record);
}