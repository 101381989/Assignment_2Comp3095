package com.springSocial.postService.service;

import com.springSocial.postService.dto.PostList;
import com.springSocial.postService.entity.Post;
import com.springSocial.postService.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPosts() {
        List<Post> postList = postRepository.findAll();
        return postList;
    }

    public void deletePost(Long id) {
       postRepository.deleteById(id);
    }

    public PostList getPostByUserId(Long userId){
        return new PostList(postRepository.findByUserId(userId));
    }

}
