package com.bianca.my_blog_app.repository;

import com.bianca.my_blog_app.entity.Comment;
import com.bianca.my_blog_app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPost(Post post);
}