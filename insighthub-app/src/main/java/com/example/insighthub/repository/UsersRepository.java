package com.example.insighthub.repository;

import com.example.insighthub.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsersRepository extends MongoRepository<User, String> {
    List<User> findByAgeGreaterThan(int age);
}
