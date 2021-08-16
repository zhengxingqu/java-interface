package com.example.demo.service;

import com.example.demo.model.CaseGroupManagement;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface CaseGroupManagementService {
    Page<CaseGroupManagement> findAllCaseGroup(int page, int size);

    CaseGroupManagement findCaseGroupById(int id);

    void updateCaseGroup(CaseGroupManagement caseGroupManagement, Integer id) throws Exception;

    void insertCaseGroup(CaseGroupManagement caseGroupManagement) throws Exception;

    void deleteCaseGroup(int id);

    Page<CaseGroupManagement> findSearchCaseGroup(Integer page, Integer size, CaseGroupManagement caseGroupManagement);

    List findCaseGroupName(String caseGroupName);

    void deleteCaseGroups(Map map) throws InterruptedException;
    void copyCase(CaseGroupManagement caseGroupManagement);
}
