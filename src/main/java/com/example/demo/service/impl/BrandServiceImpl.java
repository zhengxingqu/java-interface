package com.example.demo.service.impl;

import com.example.demo.mapper.BrandMapper;
import com.example.demo.model.Brand;
import com.example.demo.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBrand(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBrand(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBrand(int id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (!StringUtil.isEmpty(brand.getName())) {

                criteria.andLike("name", "%" + brand.getName() + "%");
            }
            if (brand.getLetter() != null && !"".equals(brand.getLetter())) {
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return brandMapper.selectByExample(example);
    }

    @Override
    public Page<Brand> findSearchPage(Integer page, Integer size, Brand brand) {
        PageHelper.startPage(page, size);
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (!StringUtil.isEmpty(brand.getName())) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }
            if (brand.getLetter() != null && !"".equals(brand.getLetter())) {
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        List<Brand> pageBrand = brandMapper.selectByExample(example);
        return (Page<Brand>)pageBrand;
    }



}
