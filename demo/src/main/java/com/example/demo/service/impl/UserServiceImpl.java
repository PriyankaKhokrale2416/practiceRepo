package com.example.demo.service.impl;


import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  //  Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        log.info("in service createUser, calling dao/repo");
        User savedUser = userRepository.save(user);
        log.info("call completed");

        return savedUser;
    }

    @Override
    public User updateUser(User user, Long id) {
      User user1 = userRepository.findById(id).get();
      user1.setUserId(user.getUserId());
      user1.setUserName(user.getUserName());
      user1.setUserAge(user.getUserAge());
      user1.setAbout(user.getAbout());

      return user1;
    }

    @Override
    public void deleteUser(Long id) {
      userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        User user1 = userRepository.findById(id).get();

        return user1;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
