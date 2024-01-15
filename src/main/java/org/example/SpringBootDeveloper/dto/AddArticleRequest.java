package org.example.SpringBootDeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.SpringBootDeveloper.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest { // 컨트롤러에서 요청하는 본문(DB의 하나)를 받을 객체
    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder().title(title).content(content).build();
    }

}
