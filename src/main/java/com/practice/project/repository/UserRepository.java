package com.practice.project.repository;

import com.practice.project.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String s);
}
