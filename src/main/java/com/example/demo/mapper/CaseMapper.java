package com.example.demo.mapper;

import com.example.demo.model.CaseManagement;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface CaseMapper extends Mapper<CaseManagement> {
    @Update("update case_management set result=#{result} where id=#{id}")
    void updateResult(Integer id, String result);
    @Update("update case_management set result=#{result}, errorResponse=#{errorResponse} where id=#{id}")
    void updateErrorResponse(Integer id, String result, String errorResponse);
}
