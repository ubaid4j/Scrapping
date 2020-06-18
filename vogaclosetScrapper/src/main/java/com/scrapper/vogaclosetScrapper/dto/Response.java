package com.scrapper.vogaclosetScrapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Response {
    private Long total;
    private List<ProductDTO> list;
}
