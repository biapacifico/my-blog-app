package com.bianca.my_blog_app.repository;

import com.bianca.my_blog_app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}