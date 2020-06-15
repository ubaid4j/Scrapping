package com.scrapper.gapScrapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Response {
    private String countPerPage;
    private String totalCount;
    private String totalPages;
    private String page;
    private List<ProductDTO> products;
}
