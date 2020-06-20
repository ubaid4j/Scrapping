package com.scrapper.gapScrapper.services;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.google.gson.Gson;
import com.scrapper.gapScrapper.dao.ProductRepo;
import com.scrapper.gapScrapper.dto.ChildCategory;
import com.scrapper.gapScrapper.dto.ProductDTO;
import com.scrapper.gapScrapper.dto.Response;
import com.scrapper.gapScrapper.entity.Product;
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


        List<WebRequestWrapper> requests = postRequestService.generatePostRequests();
        final Gson gson = new Gson();
        final WebClient webClient = new WebClient();


        requests.forEach(request -> {
            try {
                Page page = webClient.getPage(request.getWebRequest());
                WebResponse webResponse = page.getWebResponse();
                String json = webResponse.getContentAsString();
                Response response = gson.fromJson(json, Response.class);
                assert response != null;

                List<ProductDTO> productDTOS = response.getProductCategoryFacetedSearch().getProductCategory().getChildProducts();
                if (productDTOS != null) {
                    productDTOS.forEach(productDTO -> {
                        Product product = new Product();
                        productDTO.setCategory(request.getCategory());
                        product = product.createProduct(productDTO);
                        productRepo.save(product);
                    });
                } else {
                    for (ChildCategory childCategory : response.getProductCategoryFacetedSearch().getProductCategory().getChildCategories()) {
                        childCategory.getChildProducts().forEach(productDTO -> {
                            Product product = new Product();
                            productDTO.setCategory(request.getCategory());
                            product = product.createProduct(productDTO);
                            productRepo.save(product);
                        });
                    }
                }


            } catch(IOException exp) {
                exp.printStackTrace();
            }
        });



    }
}
