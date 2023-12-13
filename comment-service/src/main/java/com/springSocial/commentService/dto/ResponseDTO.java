package com.springSocial.commentService.dto;

import com.springSocial.commentService.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class ResponseDTO {

    private String comment;
    private Date createdDate;
    private Date modifiedDate;
    private User userDetails;

}
