package com.springSocial.postService.dto;


import com.springSocial.postService.entity.Comment;
import com.springSocial.postService.entity.Post;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CommentList {

    private List<Comment> comments;
}
