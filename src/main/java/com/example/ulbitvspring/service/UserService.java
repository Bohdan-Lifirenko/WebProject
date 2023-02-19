package com.example.ulbitvspring.service;

import com.example.ulbitvspring.entity.UserEntity;
import com.example.ulbitvspring.exceptions.UserAlreadyExistException;
import com.example.ulbitvspring.exceptions.UserNotFoundExceptions;
import com.example.ulbitvspring.model.User;
import com.example.ulbitvspring.repository.UserRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Користувач з таким імям уже існує");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundExceptions {
        Optional<UserEntity> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundExceptions("Корестувач не знайдений");
        }

        return User.toModel(optionalUser.get());
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
