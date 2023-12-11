package com.springSocial.commentService.controller;

import com.springSocial.commentService.dto.CommentList;
import com.springSocial.commentService.entity.Comment;
import com.springSocial.commentService.exception.CommentException;
import com.springSocial.commentService.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        ResponseEntity<Comment> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new CommentException("Error in creating comment");
        }
        return responseEntity;
    }

    @PutMapping
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        ResponseEntity<Comment> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(commentService.updateComment(comment), HttpStatus.OK);
        } catch (Exception e) {
            throw new CommentException("Error in updating comment");
        }
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getComments() {
        ResponseEntity<List<Comment>> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(commentService.getComments(), HttpStatus.OK);
        } catch (Exception e) {
            throw new CommentException("Error in fetching comments");
        }
        return responseEntity;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id) {
        ResponseEntity<String> responseEntity;
        try {
            commentService.deleteComment(id);
            responseEntity = new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new CommentException("Error in deleting comment");
        }
        return responseEntity;
    }


    @GetMapping("/{postId}")
    public ResponseEntity<CommentList> getCommentsByPostId(@PathVariable Long postId) {
        ResponseEntity<CommentList> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
        } catch (Exception e) {
            throw new CommentException("Error in fetching comments");
        }
        return responseEntity;
    }
}
