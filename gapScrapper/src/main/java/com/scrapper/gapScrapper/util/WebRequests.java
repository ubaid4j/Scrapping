package com.scrapper.gapScrapper.util;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import lombok.SneakyThrows;

import java.net.URL;

public class WebRequests {

    @SneakyThrows
    public static WebRequest getWebRequest() {
        URL url = new URL("https://api.gap.com/ux/web/productdiscovery-web-experience/products/us/gap");
        WebRequest requestSettings = new WebRequest(url, HttpMethod.GET);
        requestSettings.setAdditionalHeader("Accept", "*/*");
        requestSettings.setAdditionalHeader("Accept-Encoding", "gzip, deflate, br");
        requestSettings.setAdditionalHeader("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8,ur;q=0.7");
        requestSettings.setAdditionalHeader("apikey", "sUUYuywr9UU9HK8vYHJau88omwJoxQhs");
        requestSettings.setAdditionalHeader("Connection", "keep-alive");
        requestSettings.setAdditionalHeader("Host", "api.gap.com");
        requestSettings.setAdditionalHeader("Origin", "https://www.gap.com");
        requestSettings.setAdditionalHeader("Referer", "https://www.gap.com/browse/category.do?cid=13658&nav=hamnav%3AWomen%3A%3ADresses");
        requestSettings.setAdditionalHeader("Sec-Fetch-Dest", "empty");
        requestSettings.setAdditionalHeader("Sec-Fetch-Mode", "cors");
        requestSettings.setAdditionalHeader("Sec-Fetch-Site", "same-site");
        requestSettings.setAdditionalHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36");
        return requestSettings;
    }

}
