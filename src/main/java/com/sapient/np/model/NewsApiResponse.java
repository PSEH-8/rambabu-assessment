package com.sapient.np.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class NewsApiResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;
}
