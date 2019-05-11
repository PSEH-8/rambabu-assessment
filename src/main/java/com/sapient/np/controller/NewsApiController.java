package com.sapient.np.controller;

import com.sapient.np.model.Article;
import com.sapient.np.model.NewsApiResponse;
import com.sapient.np.model.NewsResponseWrapper;
import com.sapient.np.service.NewsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsApiController {

    @Autowired
    private NewsApiService newsApiService;

    //https://newsapi.org/v2/top-headlines?country=us
    //&category=business&apiKey=ccaf5d41cc5140c984818c344edcc14d

    //http://localhost:8080/news/business/us
    @GetMapping("/news/{category}/{country}")
    public NewsResponseWrapper news(@PathVariable("category") String category,
                          @PathVariable("country") String country) {
        NewsResponseWrapper newsResponseWrapper = newsApiService
                .findArticlesByCategoryAndCountry(category, country);

        return newsResponseWrapper;
    }
}
