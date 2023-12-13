package com.springSocial.commentService.service;

import com.springSocial.commentService.dto.CommentList;
import com.springSocial.commentService.dto.ResponseDTO;
import com.springSocial.commentService.entity.Comment;
import com.springSocial.commentService.entity.User;
import com.springSocial.commentService.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Comment createComment(Comment comment) {
        comment.setCreatedDate(new Date());
        comment.setModifiedDate(new Date());
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<ResponseDTO> getComments() {
        List<ResponseDTO> responseDTOList = new ArrayList<>();

        List<Comment> commentList = commentRepository.findAll();

        for(Comment comment: commentList){
            ResponseDTO responseDTO = new ResponseDTO();
            User user = webClientBuilder.build()
                    .get().uri("http://user-service/api/user/id",
                            uriBuilder -> uriBuilder.queryParam("userId",comment.getUserId()).build())
                    .retrieve()
                    .bodyToMono(User.class)
                    .block();

            responseDTO.setComment(comment.getComment());
            responseDTO.setModifiedDate(comment.getModifiedDate());
            responseDTO.setCreatedDate(comment.getCreatedDate());
            responseDTO.setUserDetails(user);
            responseDTOList.add(responseDTO);
        }

        return responseDTOList;
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public CommentList getCommentsByPostId(Long postId){
        return new CommentList(commentRepository.findByPostId(postId));
    }
}
