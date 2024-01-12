package org.example.SpringBootDeveloper.repository;

import org.example.SpringBootDeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
