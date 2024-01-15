package org.example.SpringBootDeveloper.dto;

import lombok.Getter;
import org.example.SpringBootDeveloper.domain.Article;

@Getter
public class ArticleResponse { // 블로그에 있는 글을 보기위해 필요한 객체
    private final String title;
    private final String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content= article.getContent();
    }
}
