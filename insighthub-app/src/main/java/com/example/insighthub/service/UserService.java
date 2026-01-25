package com.example.insighthub.service;

import com.example.insighthub.model.User;
import com.example.insighthub.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepository repository;

    public List<User> getAdults() {
        return repository.findByAgeGreaterThan(18);
    }

    @PostConstruct
    public void generateUsers() {
        repository.save(User.builder()
                .age(17)
                .name("Teenager")
                .build());
        repository.save(User.builder()
                .age(18)
                .name("just-just adult")
                .build());
        repository.save(User.builder()
                .age(25)
                .name("normally adult")
                .build());
    }
}
