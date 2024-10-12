package com.ProyectRenewableEnergiesBackend.repository;

import com.ProyectRenewableEnergiesBackend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    boolean existsByNameAndYear(String name, Integer year);
    Location findByNameAndYear(String name, Integer year);
}
