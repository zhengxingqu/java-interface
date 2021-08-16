package com.example.demo.tool;

import java.util.List;

public class PageResult<T> {
    private Long total;
    private List<T> data;
    private int pageNum;
    private int pageSize;
    private int id;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PageResult(Long total, List<T> data, int pageNum, int pageSize) {
        this.total = total;
        this.data = data;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageResult(Long total, int id, int pageNum, int pageSize) {
        this.total = total;
        this.id = id;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageResult() {

    }



}
