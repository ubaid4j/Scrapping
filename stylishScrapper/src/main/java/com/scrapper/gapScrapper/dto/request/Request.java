package com.scrapper.gapScrapper.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class Request {

    private String query;
    private Filter filters;
    private List<?> numericFilters;
    private Integer pageOffset;
    private Integer pageSize;
    private Integer storeId;
    private Integer categoryLevel;

    public Request(int pageOffset, int categoryId) {
        this.query = "";
        this.pageOffset = pageOffset;
        this.pageSize = 20;
        this.storeId = 3;
        this.categoryLevel = 3;
        numericFilters = new ArrayList<>();
        filters = new Filter();
        filters.setCategoryIds(Collections.singletonList(categoryId));
    }

}
