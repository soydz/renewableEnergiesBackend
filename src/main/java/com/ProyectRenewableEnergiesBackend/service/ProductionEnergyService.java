package com.ProyectRenewableEnergiesBackend.service;

import com.ProyectRenewableEnergiesBackend.model.ProductionEnergy;
import com.ProyectRenewableEnergiesBackend.repository.ProductionEnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionEnergyService {

    @Autowired
    private ProductionEnergyRepository productionEnergyRepository;


    public ProductionEnergy add(ProductionEnergy production) {
        return productionEnergyRepository.save(production);
    }

    public List<ProductionEnergy> getAll() {
        return productionEnergyRepository.findAll();
    }

    public Optional<ProductionEnergy> getById(int id){
        return productionEnergyRepository.findById(id);
    }

    public ProductionEnergy updateById(int id, ProductionEnergy production) {
        return productionEnergyRepository.findById(id)
                .map(oldProduction -> {
                    if(production.getValue() != null) {
                        oldProduction.setValue(production.getValue());
                    }
                    return productionEnergyRepository.save(oldProduction);
                })
                .orElseThrow(() -> new RuntimeException("Location with id " + id + " not found"));
    }

    public void deleteById(int id) {
        productionEnergyRepository.deleteById(id);
    }
}
