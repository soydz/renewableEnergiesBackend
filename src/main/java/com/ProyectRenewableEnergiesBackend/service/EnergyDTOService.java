package com.ProyectRenewableEnergiesBackend.service;

import com.ProyectRenewableEnergiesBackend.DTO.EnergyDTO;
import com.ProyectRenewableEnergiesBackend.model.TypeEnergy;
import com.ProyectRenewableEnergiesBackend.repository.EnergyDTORepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnergyDTOService {

    @Autowired
    private EnergyDTORepository energyDTORepository;

    public Page<EnergyDTO> getForPage(Integer page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return energyDTORepository.getForPage(pageable);
    }

    public Page<EnergyDTO> getForType(Integer page, int size, TypeEnergy type) {
        Pageable pageable = PageRequest.of(page, size);
        return energyDTORepository.getForType(type, pageable);
    }

    public Page<EnergyDTO> getForTypeAndYear(Integer page, int size, TypeEnergy type, int year) {
        Pageable pageable = PageRequest.of(page, size);
        return energyDTORepository.getForTypeAndYear(type, year, pageable);
    }
}
