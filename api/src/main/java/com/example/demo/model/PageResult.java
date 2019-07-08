package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageResult {
    private long totalElements;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private List<Object> elements;
}
