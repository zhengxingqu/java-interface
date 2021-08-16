package com.example.demo.service;

import com.example.demo.model.Brand;
import com.github.pagehelper.Page;

import java.util.List;


public interface BrandService {
    List<Brand> findAll();
    Brand findById(Integer id);
    void updateBrand(Brand brand);
    void insertBrand(Brand brand);
    void deleteBrand(int id);
    List<Brand> findList(Brand brand);
//    PageInfo<Brand> findPage(Integer page, Integer size);
    Page<Brand> findSearchPage(Integer page, Integer size, Brand brand);


}
