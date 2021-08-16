package com.example.demo.service;

import com.example.demo.model.HeaderManagement;
import com.github.pagehelper.Page;

import java.util.List;

public interface HeaderManagementService {
    Page<HeaderManagement> findAllHeader(int page, int size);

    HeaderManagement findHeaderById(int id);

    void updateHeader(HeaderManagement headerManagement);

    void insertHeader(HeaderManagement headerManagement) throws Exception;

    void deleteHeader(int id);

    Page<HeaderManagement> findSearchHeader(Integer page, Integer size, HeaderManagement headerManagement);
    List findHeaderName(String header);

}
