package com.ProyectRenewableEnergiesBackend.service;

import com.ProyectRenewableEnergiesBackend.model.ProductionEnergy;
import com.ProyectRenewableEnergiesBackend.repository.ProductionEnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
