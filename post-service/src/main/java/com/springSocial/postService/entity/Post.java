package com.springSocial.postService.entity;

import com.springSocial.postService.dto.CommentList;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Post {

    private long postId;
    private String content;
    private Date createdDate;
    private Date modifiedDate;
    private CommentList commentList;
    private long userId;
}
