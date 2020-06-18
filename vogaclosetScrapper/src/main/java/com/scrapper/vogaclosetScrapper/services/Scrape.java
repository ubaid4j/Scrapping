package com.scrapper.vogaclosetScrapper.services;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.google.gson.Gson;
import com.scrapper.vogaclosetScrapper.dao.ProductRepo;
import com.scrapper.vogaclosetScrapper.dto.Response;
import com.scrapper.vogaclosetScrapper.entity.Product;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Scrape {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    PostRequestService postRequestService;

    @SneakyThrows
    public void run() {


        List<WebRequest> requests = postRequestService.generatePostRequests();
        final Gson gson = new Gson();
        final WebClient webClient = new WebClient();


        requests.forEach(request -> {
            try {
                Page page = webClient.getPage(request);
                WebResponse webResponse = page.getWebResponse();
                String json = webResponse.getContentAsString();
                Response response = gson.fromJson(json, Response.class);
                assert response != null;
                response.getList().forEach(productDTO -> {
                    Product product = new Product();
                    product = product.createProduct(productDTO);
                    productRepo.save(product);
                });

            } catch(IOException exp) {
                exp.printStackTrace();
            }
        });



    }
}
