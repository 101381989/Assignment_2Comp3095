package com.springSocial.userService.repository;

import com.springSocial.userService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
