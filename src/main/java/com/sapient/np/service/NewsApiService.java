package com.sapient.np.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.np.model.Article;
import com.sapient.np.model.NewsApiResponse;
import com.sapient.np.model.NewsResponseWrapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsApiService {
    private final RestTemplate restTemplate;
    private final String apiKey = "ccaf5d41cc5140c984818c344edcc14d";

    public NewsApiService(RestTemplate restTemplate, ObjectMapper mapper) {
        this.restTemplate = restTemplate;
    }

    public NewsResponseWrapper findArticlesByCategoryAndCountry(String category,
                                                            String country) {
        final String url = "https://newsapi.org/v2/top-headlines";
        NewsApiResponse response = restTemplate.getForObject(url + "?category=" + category
                + "&country=" + country + "&apiKey=" + apiKey, NewsApiResponse.class);

        NewsResponseWrapper newsResponseWrapper =
                new NewsResponseWrapper(category, country, response.getArticles());

        return newsResponseWrapper;
    }

    public void getFilteredArticles(String category, String country,
                                     String keyword, Model model) {

        NewsResponseWrapper wrapper = findArticlesByCategoryAndCountry(category, country);

        List<Article> articles = wrapper.getArticles();
        //System.out.println("articles: " + articles);

        List<Article> newArticles = new ArrayList<>();
        for (Article article : articles) {
            System.out.println("article: " + article);
            if (article.toString().contains(keyword)) {
                newArticles.add(article);
            }
        }
        System.out.println("new articles = " + newArticles);

        model.addAttribute("category", category);
        model.addAttribute("country", country);
        model.addAttribute("keyword", keyword);
        model.addAttribute("articles", newArticles);
    }

}
