package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.StatusCode;
import com.example.demo.model.Brand;
import com.example.demo.service.BrandService;
import com.example.demo.tool.PageResult;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping(value = "/{id}")
    public Brand findById(@PathVariable(value = "id") Integer id) {
        System.out.println(id);
        Brand brand = brandService.findById(id);
//        return new Result<Brand>(true, StatusCode.OK, "查询单品牌成功", brand);
        return brand;
    }

    @GetMapping(value = "/all")
    public List<Brand> findAll() {
        List<Brand> brand = brandService.findAll();
//        return new Result<List<Brand>>(true, StatusCode.OK, "查询品牌成功", brand);
        return brand;
    }

    @PutMapping(value = "/{id}")
    public List<Brand> updateBrand(@PathVariable(value = "id") Integer id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.updateBrand(brand);
//    return new Result (true,StatusCode.OK, "更新商品成功");
        return brandService.findAll();
    }

    @PostMapping(value = "/add")
    public List<Brand> insertBrand(@RequestBody Brand brand) {
        brandService.insertBrand(brand);
        return brandService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public List<Brand> deleteBrand(@PathVariable(value = "id") Integer id) {
        brandService.deleteBrand(id);
        return brandService.findAll();
    }

    @PostMapping(value = "/search/{page}/{size}")
    public Result findSearchPage(@PathVariable(value = "page") Integer page, @PathVariable(value = "size") Integer size, @RequestBody Brand brand) {
        Page<Brand> pageInfo = brandService.findSearchPage(page, size, brand);
        PageResult pageResult = new PageResult<Brand>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }


}
