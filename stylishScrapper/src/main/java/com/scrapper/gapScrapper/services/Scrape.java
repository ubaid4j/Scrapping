package com.scrapper.gapScrapper.services;

import com.gargoylesoftware.htmlunit.*;
import com.scrapper.gapScrapper.dao.ProductRepo;
import com.scrapper.gapScrapper.dto.ResponseDTO;
import com.scrapper.gapScrapper.dto.request.Request;
import com.scrapper.gapScrapper.entity.Product;
import com.scrapper.gapScrapper.util.WebRequests;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class Scrape {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    PostRequestService postRequestService;

    @SneakyThrows
    public void run() {

        List<Integer> categoriesId = Arrays.asList(23, 322, 318, 16, 8007, 295, 15, 303, 352, 348, 260, 261, 259, 128, 126, 19, 18, 8618, 20, 256, 6026, 5986);

        categoriesId.forEach(id -> {
            List<Request> totalRequests = postRequestService.generatePostRequests(id);
            totalRequests.forEach(request -> {
                WebRequest requestSettings = WebRequests.getWebRequest();
                com.google.gson.Gson gson = new com.google.gson.Gson();
                String req = gson.toJson(request, Request.class);
                WebClient webClient = new WebClient();
                requestSettings.setRequestBody(req);

                try {
                    Page page = webClient.getPage(requestSettings);
                    WebResponse webResponse = page.getWebResponse();
                    String json = webResponse.getContentAsString();

                    ResponseDTO responseDTO = gson.fromJson(json, ResponseDTO.class);

                    responseDTO.getResponse().getProducts().forEach(productDTO -> {
                        Product product = new Product();
                        product = product.createProduct(productDTO);
                        productRepo.save(product);

                    });
                } catch (IOException exp) {
                    exp.printStackTrace();
                    ;
                }
            });

        });


    }
}
