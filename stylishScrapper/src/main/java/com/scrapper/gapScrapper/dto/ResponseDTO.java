package com.scrapper.gapScrapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private String status;
    private String statusCode;
    private String statusMsg;
    private Response response;
}


