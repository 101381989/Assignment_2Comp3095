package com.springSocial.commentService.service;

import com.springSocial.commentService.dto.CommentList;
import com.springSocial.commentService.entity.Comment;
import com.springSocial.commentService.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getComments() {
        List<Comment> userList = commentRepository.findAll();
        return userList;
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public CommentList getCommentsByPostId(Long postId){
        return new CommentList(commentRepository.findByPostId(postId));
    }
}
