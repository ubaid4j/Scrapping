package com.scrapper.gapScrapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String id;
    private String sku;
    private String name;
    private Image images;
    private String color;
    private Price prices;
    private String brand;
    private String productType;
    private String url;
    private Category categories;
}
