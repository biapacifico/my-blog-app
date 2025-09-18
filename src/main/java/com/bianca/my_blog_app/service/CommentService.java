package com.bianca.my_blog_app.service;

import com.bianca.my_blog_app.entity.Comment;
import com.bianca.my_blog_app.entity.Post;
import com.bianca.my_blog_app.repository.CommentRepository;
import com.bianca.my_blog_app.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPost(Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id " + postId));
        return commentRepository.findByPost(post);
    }

    public Comment updateComment(Long id, Comment newComment){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found with id " + id));
        comment.setContent(newComment.getContent());
        return commentRepository.save(newComment);
    }

    public void deleteComment(Long id){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found with id " + id));
        commentRepository.delete(comment);
    }
}