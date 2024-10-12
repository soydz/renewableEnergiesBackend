package com.ProyectRenewableEnergiesBackend.service;

import com.ProyectRenewableEnergiesBackend.model.ConsumptionEnergy;
import com.ProyectRenewableEnergiesBackend.repository.ConsumptionEnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionEnergyService {

    @Autowired
    private ConsumptionEnergyRepository consumptionEnergyRepository;

    public ConsumptionEnergy add(ConsumptionEnergy consumption) {
        return consumptionEnergyRepository.save(consumption);
    }

    public List<ConsumptionEnergy> getAll() {
        return consumptionEnergyRepository.findAll();
    }
}
