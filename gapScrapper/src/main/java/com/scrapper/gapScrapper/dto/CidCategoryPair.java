package com.scrapper.gapScrapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CidCategoryPair {
    private String cid;
    private String category;
}
