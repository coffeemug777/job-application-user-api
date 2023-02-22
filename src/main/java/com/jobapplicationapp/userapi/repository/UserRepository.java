package com.jobapplicationapp.userapi.repository;

import com.jobapplicationapp.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByEmail(String email);
    User findFirstByEmail(String email);
}
