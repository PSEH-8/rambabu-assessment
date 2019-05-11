package com.sapient.np.service;

import com.sapient.np.model.Article;
import com.sapient.np.model.NewsResponseWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsApiServiceTest {

    @Autowired
    private NewsApiService newsApiService;


    private String category;
    private String country;
    private String keyword;

    @Before
    public void setUp() {
        category = "business";
        country = "us";
        keyword = "CEO";
    }

    @Test
    public void testFindArticlesByCategoryAndCountry() {
        NewsResponseWrapper newsResponseWrapper = newsApiService
                .findArticlesByCategoryAndCountry(category, country);
        assertNotNull(newsResponseWrapper);

        assertNotNull(newsResponseWrapper.getArticles());
        assertEquals(category, newsResponseWrapper.getCategory());
        assertEquals(country, newsResponseWrapper.getCountry());

    }

    @Test
    public void getFilteredArticles() {

    }
}