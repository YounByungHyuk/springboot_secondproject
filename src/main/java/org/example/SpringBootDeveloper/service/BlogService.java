package org.example.SpringBootDeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.SpringBootDeveloper.domain.Article;
import org.example.SpringBootDeveloper.dto.AddArticleRequest;
import org.example.SpringBootDeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    public  final BlogRepository blogRepository;
    public Article save(AddArticleRequest request){
        return  blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }
    public Article findById(long id){
        return blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: "+id));
    }
}
