package com.harshitha.production_ready_features.production_ready_features.service;

import com.harshitha.production_ready_features.production_ready_features.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO inputPost);

    List<PostDTO> getAllPosts();

    PostDTO getPostById(Long id);
}
