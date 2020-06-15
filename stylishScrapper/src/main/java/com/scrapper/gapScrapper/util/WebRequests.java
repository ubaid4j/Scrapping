package com.scrapper.gapScrapper.util;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import lombok.SneakyThrows;

import java.net.URL;

public class WebRequests {

    @SneakyThrows
    public static WebRequest getWebRequest() {
        URL url = new URL(" https://stylishop.com/proxy/rest/product/V2/listing");
        WebRequest requestSettings = new WebRequest(url, HttpMethod.POST);
        requestSettings.setAdditionalHeader("Accept", "*/*");
        requestSettings.setAdditionalHeader("Content-Type", "application/json; charset=UTF-8");
        requestSettings.setAdditionalHeader("Referer", "https://www.google.com");
        requestSettings.setAdditionalHeader("Accept-Language", "en-US,en;q=0.8");
        requestSettings.setAdditionalHeader("Accept-Encoding", "gzip,deflate,sdch");
        requestSettings.setAdditionalHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
        requestSettings.setAdditionalHeader("X-Requested-With", "XMLHttpRequest");
        requestSettings.setAdditionalHeader("Cache-Control", "no-cache");
        requestSettings.setAdditionalHeader("Pragma", "no-cache");
        requestSettings.setAdditionalHeader("Origin", "https:localhost:8888");
        return requestSettings;
    }

}
