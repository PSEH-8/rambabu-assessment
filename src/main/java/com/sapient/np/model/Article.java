package com.sapient.np.model;

import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Article {
    private static final SimpleDateFormat format =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    //private List<Source> sources;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;
    private String content;
}
