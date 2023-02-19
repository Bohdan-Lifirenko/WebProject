package com.example.ulbitvspring.controller;

import com.example.ulbitvspring.entity.UserEntity;
import com.example.ulbitvspring.exceptions.UserAlreadyExistException;
import com.example.ulbitvspring.exceptions.UserNotFoundExceptions;
import com.example.ulbitvspring.repository.UserRepo;
import com.example.ulbitvspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Корестувач успішно збережений");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Сталася помилка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Сталася помилка");
        }
    }
}
