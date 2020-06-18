package com.scrapper.vogaclosetScrapper.util;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import lombok.SneakyThrows;

import java.net.URL;

public class WebRequests {

    @SneakyThrows
    public static WebRequest getWebRequest() {
        URL url = new URL("https://catalog.vogacloset.com/");
        WebRequest requestSettings = new WebRequest(url, HttpMethod.POST);
        requestSettings.setAdditionalHeader(":authority", "recommend.vogacloset.com");
        requestSettings.setAdditionalHeader(":method", "POST");
        requestSettings.setAdditionalHeader(":path", "/");
        requestSettings.setAdditionalHeader(":scheme", "https");
        requestSettings.setAdditionalHeader("accept", "*/*");
        requestSettings.setAdditionalHeader("accept-encoding", "gzip, deflate, br");
        requestSettings.setAdditionalHeader("accept-language", "en-GB,en-US;q=0.9,en;q=0.8,ur;q=0.7");
        requestSettings.setAdditionalHeader("accept-content", "946");
        requestSettings.setAdditionalHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        requestSettings.setAdditionalHeader("origin", "https://vogacloset.com");
        requestSettings.setAdditionalHeader("referer", "https://vogacloset.com/women");
        requestSettings.setAdditionalHeader("sec-fetch-dest", "empty");
        requestSettings.setAdditionalHeader("sec-fetch-mode", "cors");
        requestSettings.setAdditionalHeader("sec-fetch-site", "same-site");
        requestSettings.setAdditionalHeader("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
        return requestSettings;
    }

}
