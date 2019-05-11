package com.sapient.np.controller;

import com.sapient.np.model.Article;
import com.sapient.np.model.NewsResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public String submit(@ModelAttribute("category") String category,
                         @ModelAttribute("country") String country,
                         @ModelAttribute("keyword") String keyword,
                         Model model) throws UnknownHostException {
        System.out.println("category = " +  category + " country = " + country
                + " keyword = " + keyword);
        NewsResponseWrapper wrapper = restTemplate
                .getForObject("http://localhost:8080/news/" + category + "/" + country,
                        NewsResponseWrapper.class);

        List<Article> articles = wrapper.getArticles();
        //System.out.println("articles: " + articles);

        model.addAttribute("category", category);
        model.addAttribute("country", country);
        model.addAttribute("keyword", keyword);

        List<Article> newArticles = new ArrayList<>();
        for (Article article : articles) {
            System.out.println("article: " + article);
            if (article.toString().contains(keyword)) {
                newArticles.add(article);
            }
        }
        System.out.println("new articles = " + newArticles);

        model.addAttribute("articles", newArticles);

        return "result";
    }
}
