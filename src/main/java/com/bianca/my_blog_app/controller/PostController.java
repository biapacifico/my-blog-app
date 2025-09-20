package com.bianca.my_blog_app.controller;

import com.bianca.my_blog_app.entity.Post;
import com.bianca.my_blog_app.service.PostService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    Post createPost(@RequestBody @Valid Post post){
        return postService.createPost(post);
    }

    @GetMapping("{id}")
    Post getPostById(@PathVariable("id") Long id){
        return postService.getPostById(id);
    }

    @GetMapping
    List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PutMapping("{id}")
    Post updatePost(@PathVariable("id") Long id, @RequestBody @Valid Post post){
        return postService.updatePost(id, post);
    }

    @DeleteMapping("{id}")
    void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }
}