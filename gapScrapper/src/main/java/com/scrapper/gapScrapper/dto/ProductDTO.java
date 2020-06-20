package com.scrapper.gapScrapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String businessCatalogItemId;
    private String name;
    private QuicklookImage quicklookImage;
    private String url;
    private Price price;
    private String category;
}
