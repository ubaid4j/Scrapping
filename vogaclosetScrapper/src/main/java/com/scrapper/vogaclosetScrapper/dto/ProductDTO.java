package com.scrapper.vogaclosetScrapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String _id;
    private String sku;
    private String name;
    private String image;
    private String url;
    private String price;
    private Attribute attributes;
}
