package com.scrapper.gapScrapper.services;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.scrapper.gapScrapper.dto.ResponseDTO;
import com.scrapper.gapScrapper.dto.request.Request;
import com.scrapper.gapScrapper.util.WebRequests;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostRequestService {

    @SneakyThrows
    public List<Request> generatePostRequests(int categoryId) {
        WebRequest webRequest = WebRequests.getWebRequest();

        Request request = new Request(1, categoryId);

        com.google.gson.Gson gson = new com.google.gson.Gson();
        String req = gson.toJson(request, Request.class);

        webRequest.setRequestBody(req);
        WebClient webClient = new WebClient();
        Page page = webClient.getPage(webRequest);
        WebResponse webResponse = page.getWebResponse();
        String json = webResponse.getContentAsString();
        ResponseDTO responseDTO = gson.fromJson(json, ResponseDTO.class);

        int totalPages = Integer.parseInt(responseDTO.getResponse().getTotalPages());

        List<Request> totalRequests = new ArrayList<>();

        for (int i = 1; i <= totalPages; i++) {
            totalRequests.add(new Request(i, categoryId));
        }

        return totalRequests;
    }

}
