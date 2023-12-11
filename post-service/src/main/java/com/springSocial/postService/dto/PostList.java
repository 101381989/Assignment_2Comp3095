package com.springSocial.postService.dto;


import com.springSocial.postService.entity.Post;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PostList {

    private List<Post> posts;
}
