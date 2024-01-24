package org.example.SpringBootDeveloper.repository;

import org.example.SpringBootDeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String Email); //이메일로 사용자 정보 가져오기
}
