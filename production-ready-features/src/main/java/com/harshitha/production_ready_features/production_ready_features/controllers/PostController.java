package com.harshitha.production_ready_features.production_ready_features.controllers;

import com.harshitha.production_ready_features.production_ready_features.dto.PostDTO;
import com.harshitha.production_ready_features.production_ready_features.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO inputPost){
        PostDTO postDTO = postService.createPost(inputPost);
        return postDTO;
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

}
