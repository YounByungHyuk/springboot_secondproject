package org.example.SpringBootDeveloper.dto;

import lombok.Getter;
import org.example.SpringBootDeveloper.domain.Article;

@Getter
public class ArticleListViewResponse {

    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        //아티클에서 가져온 것으 객체에 담음
    }
}