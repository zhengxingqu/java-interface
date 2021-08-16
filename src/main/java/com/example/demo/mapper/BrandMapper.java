package com.example.demo.mapper;

import com.example.demo.model.Brand;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper extends Mapper<Brand> {
//    @Select("SELECT * FROM tb_brand WHERE name like '%${name}%'")
//    List<Brand> selectName(Brand brand);
}
