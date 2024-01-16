package org.example.SpringBootDeveloper.controller;

import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.SpringBootDeveloper.domain.Article;
import org.example.SpringBootDeveloper.dto.ArticleListViewResponse;
import org.example.SpringBootDeveloper.dto.ArticleViewResponse;
import org.example.SpringBootDeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles); // 모델에 블로그 리스트를 article라는 어트리뷰트 명으로 저장

        return "articleList"; // articleList.html 조회
    }

    @GetMapping("/articles/{id}") // id에 URL로 넘어온 값을 받아 findnyid메서드로 넘겨 글을 조회하고 모델에 담음
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) { //id 가 없으면 생성한다.
            model.addAttribute("article", new ArticleViewResponse());
        } else { // 아이디가 있으면 수정한다.
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }

}