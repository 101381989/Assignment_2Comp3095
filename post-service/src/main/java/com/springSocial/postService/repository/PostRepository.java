package com.springSocial.postService.repository;

import com.springSocial.postService.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post,Long> {

    public List<Post> findByUserId(Long userId);
}
