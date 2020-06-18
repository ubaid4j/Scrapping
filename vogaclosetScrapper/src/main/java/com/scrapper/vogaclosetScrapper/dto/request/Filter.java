package com.scrapper.vogaclosetScrapper.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Filter {
    private List<Integer> categoryIds;
}
