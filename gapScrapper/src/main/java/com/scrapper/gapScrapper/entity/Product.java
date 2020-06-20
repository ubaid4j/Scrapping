package com.scrapper.gapScrapper.entity;

import com.scrapper.gapScrapper.dto.ProductDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String link;
    private String image;
    private String categoryName;
    private String price;
    private String description;

    public Product createProduct(ProductDTO productDTO) {
        try {
            setLink("https://www.gap.com/browse/product.do?pid=" + productDTO.getBusinessCatalogItemId());
            setImage(productDTO.getQuicklookImage().getPath());
            setCategoryName(productDTO.getCategory());
            setPrice(productDTO.getPrice().getRegularMaxPrice());
            setDescription(productDTO.getName());
            return this;
        } catch (Exception ignore) {
            return this;
        }
    }

}
