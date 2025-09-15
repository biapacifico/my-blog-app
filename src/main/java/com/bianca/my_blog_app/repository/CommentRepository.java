package com.bianca.my_blog_app.repository;

import com.bianca.my_blog_app.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}