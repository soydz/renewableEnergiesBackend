package com.ProyectRenewableEnergiesBackend.service;

import com.ProyectRenewableEnergiesBackend.DTO.UserLogin;
import com.ProyectRenewableEnergiesBackend.DTO.UserResponse;
import com.ProyectRenewableEnergiesBackend.model.User;
import com.ProyectRenewableEnergiesBackend.repository.UserRepository;
import com.ProyectRenewableEnergiesBackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    @Autowired
    private JwtUtil jwtUtil;

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
        return userRepository.findAll();
    }

    public Optional<User> getById(String username) {
        return userRepository.findById(username);
    }

    public String updateById(User user) {
        Optional<User> userBd = userRepository.findById(user.getUserName());
        if(userBd.isPresent()){
            User userUpdate = userBd.get();
            userUpdate.setName(user.getName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setEmail(user.getEmail());
            userRepository.save(userUpdate);

            return generateToken(userUpdate);
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    public void deleteById(String username) {
        userRepository.deleteById(username);
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

    public String login(UserLogin userLogin) {
       Optional<User> user = getById(userLogin.getUserName());

       if(user.isPresent()){
           boolean correctPassword = verifyPassword(userLogin.getPassword(), user.get().getPassword());
           if(correctPassword) {
               return generateToken(user.get());
           }
       }
        return null;
    }

    public String generateToken(User user) {
        UserResponse userResponse = new UserResponse(
                user.getUserName(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getPermissions()
        );
        return jwtUtil.generateToken(userResponse);
    }
}
