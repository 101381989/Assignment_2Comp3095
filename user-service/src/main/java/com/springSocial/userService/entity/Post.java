package com.springSocial.userService.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Post {

    private long postId;
    private String content;
    private Date createdDate;
}
