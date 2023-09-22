package com.lcwd.orm.services.impl;

import com.lcwd.orm.entities.User;
import com.lcwd.orm.repositories.UserRepository;
import com.lcwd.orm.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;

@Service
public class UserServiceImpl implements UserService
{
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user)
    {
        User savedUser = userRepository.save(user);
        logger.info("User saved : {}", savedUser.getId());
        return savedUser;
    }

    @Override
    public User updateUser(User user, int userId)
    {
    //  1. user get database
        User oldUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with given ID not found"));
        oldUser.setName(user.getName());
        oldUser.setCity(user.getCity());
        oldUser.setAge(user.getAge());
        // rest of the details also be updated

        // 2.  update user
        User updatedUser = userRepository.save(oldUser);

        return updatedUser;
    }

    @Override
    public void deleteUser(int userId)
    {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with given ID not found"));
        userRepository.delete(user);
        logger.info("user deleted of that particular ID -> {}", userId);
    }

    // to get All the User
    @Override
    public List<User> getAllUser()
    {
        List<User> users = userRepository.findAll();
        return users;
    }


    // get Single User with given ID
    @Override
    public User getUser(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new RuntimeException("User with given ID not found"));

        return user;
    }
}
