package com.scrapper.gapScrapper.entity;

import com.scrapper.gapScrapper.dto.ProductDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

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
            this.link = productDTO.getUrl();
            this.image = productDTO.getImages().getImage();
            try {
                try {
                    this.categoryName = productDTO.getCategories().getLevel2().get(1);
                } catch(NullPointerException ignore) {
                    this.categoryName = productDTO.getCategories().getLevel2().get(0);
                }
            } catch (Exception exp) {
                categoryName = "No available";
            }
            this.price = productDTO.getPrices().getPrice();
            this.description = productDTO.getName();
        } catch (Exception ignore) {

        }

        return this;

    }

}
