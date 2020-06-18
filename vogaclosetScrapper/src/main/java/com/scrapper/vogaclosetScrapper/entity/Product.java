package com.scrapper.vogaclosetScrapper.entity;

import com.scrapper.vogaclosetScrapper.dto.ProductDTO;
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
            setLink("https:" + productDTO.getUrl());
            setImage("https:" + productDTO.getImage());
            setCategoryName(productDTO.getAttributes().getBase_category_path_name_data());
            setPrice(productDTO.getPrice());
            setDescription(productDTO.getName());
            return this;
        } catch (Exception ignore) {
            return this;
        }
    }

}
