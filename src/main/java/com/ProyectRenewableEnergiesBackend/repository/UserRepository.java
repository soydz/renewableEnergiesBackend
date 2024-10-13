package com.ProyectRenewableEnergiesBackend.repository;

import com.ProyectRenewableEnergiesBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
}
