package com.springSocial.commentService.repository;

import com.springSocial.commentService.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    public List<Comment> findByPostId(long postId);
}
