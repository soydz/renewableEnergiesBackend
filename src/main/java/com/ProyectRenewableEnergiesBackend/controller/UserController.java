package com.ProyectRenewableEnergiesBackend.controller;

import com.ProyectRenewableEnergiesBackend.DTO.UserLogin;
import com.ProyectRenewableEnergiesBackend.DTO.UserResponse;
import com.ProyectRenewableEnergiesBackend.model.User;
import com.ProyectRenewableEnergiesBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        User newUser = userService.add(user);
        if(newUser == null) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserLogin dataLogin) {
        String userToken = userService.login(dataLogin);
        if(userToken == null) {
            return new ResponseEntity<>(Map.of("message","Credenciales inválidas"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(Map.of("token", userToken), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> userList = userService.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") String username) {
        Optional<User> user = userService.getById(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> updateById(@RequestBody User user) {
        String userUpdateToken = userService.updateById(user);
        return new ResponseEntity<>(Map.of("token", userUpdateToken), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable("id") String username) {
        userService.deleteById(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
