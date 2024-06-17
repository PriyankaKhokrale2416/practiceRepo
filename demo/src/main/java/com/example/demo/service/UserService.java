package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);
    public User updateUser(User user, Long id);
    public void deleteUser(Long id);
    public User getUserById(Long id);
    public List<User> getAllUsers();




}
