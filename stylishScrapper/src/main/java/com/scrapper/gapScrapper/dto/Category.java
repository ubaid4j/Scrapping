package com.scrapper.gapScrapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Category {

    private List<String> level0;
    private List<String> level1;
    private List<String> level2;
    private List<String> level3;
}
