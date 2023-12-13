package com.springSocial.userService.service;

//import com.springSocial.userService.dto.PostList;
import com.springSocial.userService.entity.User;
import com.springSocial.userService.repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final WebClient.Builder webClientBuilder;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @CircuitBreaker(name = "userService",fallbackMethod = "getAllAvailablePosts")
    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
//        for (User user: userList){
//            user.setPosts(restTemplate.getForEntity("http://post-service/post/"+user.getId(), PostList.class).getBody());
//        }
        return userList;
    }

    public void deleteUser(Long id) {
       userRepository.deleteById(id);
    }

    public User getUserByUserId(long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
