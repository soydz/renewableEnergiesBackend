package com.ProyectRenewableEnergiesBackend.service;

import com.ProyectRenewableEnergiesBackend.model.ConsumptionEnergy;
import com.ProyectRenewableEnergiesBackend.repository.ConsumptionEnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<ConsumptionEnergy> getById(int id){
        return consumptionEnergyRepository.findById(id);
    }

    public ConsumptionEnergy updateById(int id, ConsumptionEnergy consumption) {
        return consumptionEnergyRepository.findById(id)
                .map(oldConsumption -> {
                    if(consumption.getValue() != null) {
                        oldConsumption.setValue(consumption.getValue());
                    }
                    return consumptionEnergyRepository.save(oldConsumption);
                })
                .orElseThrow(() -> new RuntimeException("Location with id " + id + " not found"));
    }

    public void deleteById(int id) {
        consumptionEnergyRepository.deleteById(id);
    }
}
