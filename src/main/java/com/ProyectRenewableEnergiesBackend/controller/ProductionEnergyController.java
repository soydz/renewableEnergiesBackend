package com.ProyectRenewableEnergiesBackend.controller;

import com.ProyectRenewableEnergiesBackend.model.ProductionEnergy;
import com.ProyectRenewableEnergiesBackend.service.ProductionEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProductionEnergy> getById(@PathVariable("id") int id) {
        Optional<ProductionEnergy> productionEnergy = productionEnergyService.getById(id);
        return productionEnergy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductionEnergy> updateById(@PathVariable("id") int id, @RequestBody ProductionEnergy production) {
        ProductionEnergy newProduction = new ProductionEnergy();
        if(production.getValue() != null) {
            newProduction.setValue(production.getValue());
        }
        ProductionEnergy updateProduction = productionEnergyService.updateById(id, newProduction);
        return new ResponseEntity<>(updateProduction, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductionEnergy> deleteById(@PathVariable("id") int id) {
        productionEnergyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
