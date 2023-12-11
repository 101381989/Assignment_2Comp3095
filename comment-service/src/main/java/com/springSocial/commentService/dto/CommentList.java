package com.springSocial.commentService.dto;

import com.springSocial.commentService.entity.Comment;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CommentList {

    private List<Comment> comments;
}
