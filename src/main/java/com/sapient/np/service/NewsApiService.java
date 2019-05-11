package com.sapient.np.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.np.model.NewsApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsApiService {
    private final RestTemplate restTemplate;
    private final String apiKey = "ccaf5d41cc5140c984818c344edcc14d";

    public NewsApiService(RestTemplate restTemplate, ObjectMapper mapper) {
        this.restTemplate = restTemplate;
    }

    public NewsApiResponse findArticlesByCategoryAndCountry(String category,
                                                            String country) {
        final String url = "https://newsapi.org/v2/top-headlines";
        NewsApiResponse response = restTemplate.getForObject(url + "?category=" + category
                + "&country=" + country + "&apiKey=" + apiKey, NewsApiResponse.class);
        return response;
    }

}
