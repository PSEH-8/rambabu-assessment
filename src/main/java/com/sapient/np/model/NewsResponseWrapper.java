package com.sapient.np.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class NewsResponseWrapper {
    private String category;
    private String country;
    private List<Article> articles;
}
