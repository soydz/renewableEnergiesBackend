package com.ProyectRenewableEnergiesBackend.service;

import com.ProyectRenewableEnergiesBackend.DTO.UserResponse;
import com.ProyectRenewableEnergiesBackend.model.User;
import com.ProyectRenewableEnergiesBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User add(User user) {
        return userRepository.save(user);
    }

    public List<UserResponse> getAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(this::createUserResponse)  //.map( oldUser -> createUserResponse(oldUser))
                .collect(Collectors.toList());
    }

    public Optional<UserResponse> getById(String username) {
        Optional<User> user = userRepository.findById(username);
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(user.get().getUserName());
        userResponse.setName(user.get().getName());
        userResponse.setLastName(user.get().getLastName());
        userResponse.setEmail(user.get().getEmail());
        userResponse.setPermissions(user.get().getPermissions());
        return Optional.of(userResponse); // TODO controlar cuando el id es nulo
    }

    public void deleteById(String usernane) {
        userRepository.deleteById(usernane);
    }

    public boolean existByUsername(String username) {
        return userRepository.existsById(username);
    }

    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    public UserResponse createUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(user.getUserName());
        userResponse.setName(user.getName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPermissions(user.getPermissions());

        return userResponse;
    }
}
