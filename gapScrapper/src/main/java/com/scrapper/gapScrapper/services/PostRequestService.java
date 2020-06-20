package com.scrapper.gapScrapper.services;

import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.scrapper.gapScrapper.dto.CidCategoryPair;
import com.scrapper.gapScrapper.util.WebRequests;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostRequestService {

    @SneakyThrows
    public List<WebRequestWrapper> generatePostRequests() {

        List<WebRequestWrapper> webRequests = new ArrayList<>();

        List<CidCategoryPair> cids = Arrays.asList(
                new CidCategoryPair("13658", "Women Dresses"),
                new CidCategoryPair("17076", "Women T-Shirts"),
                new CidCategoryPair("5664", "Women Jeans"),
                new CidCategoryPair("1041168", "Women Sweat Shirts and Pants"),
                new CidCategoryPair("5745", "Women Sweaters"),
                new CidCategoryPair("1152367", "Women Jump Suits & Rompers"),
                new CidCategoryPair("34608", "Women Shirts and Tops"),
                new CidCategoryPair("35300", "Women Shoes and Accessories"),
                new CidCategoryPair("6998", "Men Jeans"),
                new CidCategoryPair("5225", "Men T-Shirts"),
                new CidCategoryPair("83056", "Men Polos"),
                new CidCategoryPair("15043", "Men Shirts"),
                new CidCategoryPair("80799", "Men Pants"),
                new CidCategoryPair("8655", "Men Joggers")
        );

        cids.forEach(cid -> {
            final WebRequest webRequest = WebRequests.getWebRequest();
            webRequest.setRequestParameters(getFormData(cid.getCid()));
            WebRequestWrapper webRequestWrapper = new WebRequestWrapper();
            webRequestWrapper.setCategory(cid.getCategory());
            webRequestWrapper.setWebRequest(webRequest);
            webRequests.add(webRequestWrapper);
        });


        return webRequests;
    }

    private List<NameValuePair> getFormData(String cid) {
        List<NameValuePair> formData = new ArrayList<>();
        formData.add(new NameValuePair("rsId", "982635773345060"));
        formData.add(new NameValuePair("abSeg", "{\"at03\":\"x\",\"at04\":\"a\",\"at05\":\"a\",\"at06\":\"a\",\"br04\":\"a\",\"br05\":\"a\",\"br06\":\"a\",\"gap01\":\"a\",\"gap03\":\"a\",\"gap04\":\"a\",\"gap06\":\"a\",\"gap16\":\"x\",\"hc01\":\"x\",\"hc03\":\"b\",\"on01\":\"x\",\"on04\":\"a\",\"on06\":\"a\",\"on16\":\"x\",\"pdpRedesign\":\"Bricks2\",\"pgAT\":\"p\",\"pgBR\":\"p\",\"pgGP\":\"p\",\"pgHC\":\"p\",\"pgON\":\"p\",\"test\":\"a\",\"v\":\"2\"}"));
        formData.add(new NameValuePair("cid", cid));
        formData.add(new NameValuePair("isFacetsEnabled", "true"));
        formData.add(new NameValuePair("globalShippingCountryCode", "us"));
        formData.add(new NameValuePair("globalShippingCurrencyCode", "USD"));
        formData.add(new NameValuePair("locale", "en_US"));
        formData.add(new NameValuePair("pageId", "0"));
        return formData;
    }

}
