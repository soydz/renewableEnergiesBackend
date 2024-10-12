package com.ProyectRenewableEnergiesBackend.controller;

import com.ProyectRenewableEnergiesBackend.model.ProductionEnergy;
import com.ProyectRenewableEnergiesBackend.service.ProductionEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production")
public class ProductionEnergyController {

    @Autowired
    ProductionEnergyService productionEnergyService;

    @PostMapping
    public ResponseEntity<ProductionEnergy> add(@RequestBody ProductionEnergy production) {
        ProductionEnergy newProductionEnergy = productionEnergyService.add(production);
        return new ResponseEntity<>(newProductionEnergy, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductionEnergy>> getAll() {
        List<ProductionEnergy> productionEnergyList = productionEnergyService.getAll();
        return new ResponseEntity<>(productionEnergyList, HttpStatus.OK);
    }

}
