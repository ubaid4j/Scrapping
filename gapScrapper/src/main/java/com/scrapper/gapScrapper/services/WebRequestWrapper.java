package com.scrapper.gapScrapper.services;

import com.gargoylesoftware.htmlunit.WebRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebRequestWrapper {
    private WebRequest webRequest;
    private String category;
}
