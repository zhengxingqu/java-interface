package com.example.demo.service;

import com.example.demo.entity.Result;
import com.example.demo.model.CaseManagement;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CaseManagementService {
    Page<CaseManagement> findAllCase(int page, int size);

    CaseManagement findCaseById(int id);

    void updateCase(CaseManagement caseManagement);

    void insertCase(CaseManagement caseManagement) throws Exception;

    void deleteCase(int id);

    Page<CaseManagement> findSearchCase(Integer page, Integer size, CaseManagement caseManagement);

    List findCaseName(String caseName);

    void interfaceRequest(Map map, Integer id) throws Exception;

    void updateErrorResponse(Integer id, String result, String errorResponse);

    void deleteCases(Map map) throws InterruptedException;

    Result runManyInterfaceRequest(Map map);

    void copyCase(CaseManagement caseManagement);

    List getCaseName();

    Result uploadExcel(MultipartFile file, CaseManagement caseManagement) throws Exception;

    void downloadExcel(Map ids);
}
