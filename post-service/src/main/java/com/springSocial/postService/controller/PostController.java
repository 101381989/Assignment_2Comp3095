package com.springSocial.postService.controller;

import com.springSocial.postService.dto.PostList;
import com.springSocial.postService.entity.Post;
import com.springSocial.postService.exception.PostException;
import com.springSocial.postService.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        ResponseEntity<Post> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new PostException("Error in creating user");
        }
        return responseEntity;
    }

    @PutMapping
    public ResponseEntity<Post> updateUser(@RequestBody Post user) {
        ResponseEntity<Post> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(postService.updatePost(user), HttpStatus.OK);
        } catch (Exception e) {
            throw new PostException("Error in updating user");
        }
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        ResponseEntity<List<Post>> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
        } catch (Exception e) {
            throw new PostException("Error in fetching users");
        }
        return responseEntity;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        ResponseEntity<String> responseEntity;
        try {
            postService.deletePost(id);
            responseEntity = new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new PostException("Error in deleting user");
        }
        return responseEntity;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<PostList> getPostsByUserId(@PathVariable Long userId) {
        ResponseEntity<PostList> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(postService.getPostByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            throw new PostException("Error in fetching users");
        }
        return responseEntity;
    }
}
