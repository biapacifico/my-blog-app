package com.bianca.my_blog_app.controller;

import com.bianca.my_blog_app.entity.Comment;
import com.bianca.my_blog_app.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping
    Comment createComment(Comment comment){
        return commentService.createComment(comment);
    }

    @GetMapping("{postId}")
    List<Comment> getCommentsByPost(@RequestParam("postId") Long postId){
        return commentService.getCommentsByPost(postId);
    }

    @PutMapping("{id}")
    Comment updateComment(@PathVariable("id") Long id, @RequestBody @Valid Comment comment){
        return  commentService.updateComment(id, comment);
    }

    @DeleteMapping("{id}")
    void deleteComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
    }
}