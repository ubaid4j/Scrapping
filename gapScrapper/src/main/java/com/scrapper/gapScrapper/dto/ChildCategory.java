package com.scrapper.gapScrapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ChildCategory {
    private List<ProductDTO> childProducts;
}
