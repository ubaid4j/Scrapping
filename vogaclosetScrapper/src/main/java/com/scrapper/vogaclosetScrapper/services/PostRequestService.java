package com.scrapper.vogaclosetScrapper.services;

import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.scrapper.vogaclosetScrapper.util.WebRequests;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostRequestService {

    @SneakyThrows
    public List<WebRequest> generatePostRequests() {

        List<WebRequest> webRequests = new ArrayList<>();

        List<String> ecds = Arrays.asList("[{\"type\":\"category-view\",\"id\":\"55\",\"path\":\"3/55\"}]",
                "[{\"type\":\"category-view\",\"id\":\"56\",\"path\":\"3/56\"}]",
                "[{\"type\":\"category-view\",\"id\":\"57\",\"path\":\"3/57\"}]",
                "[{\"type\":\"category-view\",\"id\":\"2397\",\"path\":\"2396/2397\"}]",
                "[{\"type\":\"category-view\",\"id\":\"2398\",\"path\":\"2396/2398\"}]",
                "[{\"type\":\"category-view\",\"id\":\"2399\",\"path\":\"2396/2399\"}]",
                "[{\"type\":\"category-view\",\"id\":\"58\",\"path\":\"4/58\"}]",
                "[{\"type\":\"category-view\",\"id\":\"54\",\"path\":\"4/54\"}]",
                "[{\"type\":\"category-view\",\"id\":\"59\",\"path\":\"4/59\"}]",
                "[{\"type\":\"category-view\",\"id\":\"61\",\"path\":\"5/61\"}]",
                "[{\"type\":\"category-view\",\"id\":\"62\",\"path\":\"5/62\"}]",
                "[{\"type\":\"category-view\",\"id\":\"63\",\"path\":\"5/63\"}]",
                "[{\"type\":\"category-view\",\"id\":\"2327\",\"path\":\"2311/2327\"}]");

        ecds.forEach(ecd -> {
            final WebRequest webRequest = WebRequests.getWebRequest();
            webRequest.setRequestParameters(getFormData(ecd));
            webRequests.add(webRequest);
        });

        return webRequests;
    }

    private List<NameValuePair> getFormData(String ecd) {
        List<NameValuePair> formData = new ArrayList<>();
        formData.add(new NameValuePair("acc", "40854a04ca9a9fa7"));
        formData.add(new NameValuePair("ecd", ecd));
        formData.add(new NameValuePair("ccc", "SAR"));
        formData.add(new NameValuePair("csc", "default"));
        formData.add(new NameValuePair("ctg", "{\"limit\":2000,\"skip\":95,\"filters\":{},\"sort\":{},\"segment\":\"SortingAlgorithmPublishDate\",\"platform\":\"Web\",\"is_debug_mode\":false,\"is_personalized\":false,\"is_preview_ruleset\":false,\"current_country\":\"SA\"}"));
        return formData;
    }

}
