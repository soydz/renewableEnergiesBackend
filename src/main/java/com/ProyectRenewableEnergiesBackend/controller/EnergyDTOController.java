package com.ProyectRenewableEnergiesBackend.controller;

import com.ProyectRenewableEnergiesBackend.DTO.EnergyDTO;
import com.ProyectRenewableEnergiesBackend.model.TypeEnergy;
import com.ProyectRenewableEnergiesBackend.service.EnergyDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/energy")
@CrossOrigin(origins = "http://localhost:4200")
public class EnergyDTOController {

    @Autowired
    EnergyDTOService energyDTOService;
/*
    @GetMapping
    public ResponseEntity<Page<EnergyDTO>> get(
            @RequestParam(name = "page") Integer page) {
        int size = 10;
        Page<EnergyDTO> data = energyDTOService.getForPage(page, size);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

 */

    @GetMapping
    public ResponseEntity<Page<EnergyDTO>> get(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "typeEnergy") TypeEnergy typeEnergy,
            @RequestParam(name = "year") Integer year
        ) {
        int size = 10;
        if(year == 0){
            Page<EnergyDTO> data = energyDTOService.getForType(page, size, typeEnergy);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        Page<EnergyDTO> data = energyDTOService.getForTypeAndYear(page, size, typeEnergy, year);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{page}")
    public ResponseEntity<Page<EnergyDTO>> getByPage(@PathVariable("page") Integer page) {
        int size = 10;
        Page<EnergyDTO> data = energyDTOService.getForPage(page, size);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{page}/{type}")
    public ResponseEntity<Page<EnergyDTO>> getByEnergy(@PathVariable("page") Integer page , @PathVariable("type") TypeEnergy type){
        int size = 10;
        Page<EnergyDTO> data = energyDTOService.getForType(page, size, type);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{page}/{type}/{year}")
    public ResponseEntity<Page<EnergyDTO>> getByEnergyAndYear(
            @PathVariable("page") Integer page,
            @PathVariable("type") TypeEnergy type,
            @PathVariable("year") Integer year
    ){
        int size = 10;
        Page<EnergyDTO> data = energyDTOService.getForTypeAndYear(page, size, type, year);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
