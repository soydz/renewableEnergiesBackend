package com.ProyectRenewableEnergiesBackend.service;

import com.ProyectRenewableEnergiesBackend.DTO.UserLogin;
import com.ProyectRenewableEnergiesBackend.DTO.UserResponse;
import com.ProyectRenewableEnergiesBackend.model.User;
import com.ProyectRenewableEnergiesBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User add(User user) {
        if(!existByUsername(user.getUserName()) && !existByEmail(user.getEmail())){
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public List<User> getAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public Optional<User> getById(String username) {
        return userRepository.findById(username);
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

    public boolean verifyPassword(String passwordPlana, String hashedPassword) {
        return passwordEncoder.matches(passwordPlana, hashedPassword);
    }

    public UserResponse login(UserLogin userLogin) {
       Optional<User> user = getById(userLogin.getUserName());

       if(user.isPresent()){
           boolean correctPassword = verifyPassword(userLogin.getPassword(), user.get().getPassword());
           if(correctPassword) {
               UserResponse userResponse = new UserResponse(
                       user.get().getUserName(),
                       user.get().getName(),
                       user.get().getLastName(),
                       user.get().getEmail(),
                       user.get().getPermissions()
               );
               return userResponse;
           }
       }
        return null;
    }
}
