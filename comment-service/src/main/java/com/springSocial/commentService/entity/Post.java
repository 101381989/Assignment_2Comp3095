package com.springSocial.commentService.entity;

import com.springSocial.commentService.dto.CommentList;
import lombok.Data;

import java.util.Date;

@Data
public class Post {

    private long postId;
    private String content;
    private Date createdDate;
    private Date modifiedDate;
    private CommentList commentList;
    private long userId;
}
