package com.ProyectRenewableEnergiesBackend.repository;

import com.ProyectRenewableEnergiesBackend.DTO.EnergyDTO;
import com.ProyectRenewableEnergiesBackend.model.TypeEnergy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyDTORepository extends JpaRepository<EnergyDTO, Integer> {

    @Query("SELECT new EnergyDTO( l.name, l.year, pe.typeEnergy, pe.value, ce.value) " +
            "FROM ProductionEnergy pe " +
            "JOIN pe.location l " +
            "JOIN ConsumptionEnergy ce ON ce.location.id = l.id " +
            "WHERE pe.typeEnergy = ce.typeEnergy")
    Page<EnergyDTO> getForPage(Pageable pageable);

    @Query("SELECT new EnergyDTO( l.name, l.year, pe.typeEnergy, pe.value, ce.value) " +
            "FROM ProductionEnergy pe " +
            "JOIN pe.location l " +
            "JOIN ConsumptionEnergy ce ON ce.location.id = l.id " +
            "WHERE pe.typeEnergy = ce.typeEnergy AND pe.typeEnergy = :typeEnergy")
    Page<EnergyDTO> getForType(@Param("typeEnergy") TypeEnergy typeEnergy, Pageable pageable);

    @Query("SELECT new EnergyDTO( l.name, l.year, pe.typeEnergy, pe.value, ce.value) " +
            "FROM ProductionEnergy pe " +
            "JOIN pe.location l " +
            "JOIN ConsumptionEnergy ce ON ce.location.id = l.id " +
            "WHERE pe.typeEnergy = ce.typeEnergy AND l.year = :year AND pe.typeEnergy = :typeEnergy")
    Page<EnergyDTO> getForTypeAndYear(@Param("typeEnergy") TypeEnergy typeEnergy ,@Param("year") int year, Pageable pageable);
}
