package org.example.SpringBootDeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.example.SpringBootDeveloper.domain.Article;
import org.example.SpringBootDeveloper.dto.AddArticleRequest;
import org.example.SpringBootDeveloper.dto.ArticleResponse;
import org.example.SpringBootDeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll().stream().map(ArticleResponse::new).toList();

        return ResponseEntity.ok().body(articles);
    }

//    @GetMapping("/api/articles/{id}")
//    //url에서 해당하는 아이디 값이 들어옴
//    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
//        Article article = blogService.findById(id);
//
//        return ResponseEntity.ok()
//                .body(new ArticleResponse(article));
//    }
}
