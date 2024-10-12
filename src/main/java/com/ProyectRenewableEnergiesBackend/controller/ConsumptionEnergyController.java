package com.ProyectRenewableEnergiesBackend.controller;

import com.ProyectRenewableEnergiesBackend.model.ConsumptionEnergy;
import com.ProyectRenewableEnergiesBackend.service.ConsumptionEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumption")
public class ConsumptionEnergyController {

    @Autowired
    private ConsumptionEnergyService consumptionEnergyService;


    @PostMapping
    public ResponseEntity<ConsumptionEnergy> add(@RequestBody ConsumptionEnergy consumption) {
        ConsumptionEnergy newConsumptionEnergy = consumptionEnergyService.add(consumption);
        return new ResponseEntity<>(newConsumptionEnergy, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ConsumptionEnergy>> getAll() {
        List<ConsumptionEnergy> consumptionEnergyList = consumptionEnergyService.getAll();
        return new ResponseEntity<>(consumptionEnergyList, HttpStatus.OK);
    }
}
