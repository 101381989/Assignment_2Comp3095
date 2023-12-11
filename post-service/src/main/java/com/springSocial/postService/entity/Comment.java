package com.springSocial.postService.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {

    private long commentId;
    private String comment;
    private Date createdDate;
    private Date modifiedDate;
    private long postId;
}
