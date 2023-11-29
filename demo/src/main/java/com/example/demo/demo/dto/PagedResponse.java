package com.example.demo.demo.dto;

import java.util.List;

public class PagedResponse<T>{
    private int pageNo;
    private int pageSize;
    private List<T> content;

    public PagedResponse(int pageNo, int pageSize, List<T> content) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.content = content;
    }
}
