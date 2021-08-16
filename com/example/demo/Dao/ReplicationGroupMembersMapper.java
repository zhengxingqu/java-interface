package com.example.demo.Dao;

import com.example.demo.Model.ReplicationGroupMembers;

public interface ReplicationGroupMembersMapper {
    int insert(ReplicationGroupMembers record);

    int insertSelective(ReplicationGroupMembers record);
}