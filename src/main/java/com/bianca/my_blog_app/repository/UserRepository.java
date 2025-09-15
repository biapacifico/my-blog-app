package com.bianca.my_blog_app.repository;

import com.bianca.my_blog_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}