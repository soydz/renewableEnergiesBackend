package com.ProyectRenewableEnergiesBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer year;
    private String region;

    @OneToMany(targetEntity = ProductionEnergy.class, fetch = FetchType.LAZY, mappedBy = "location")
    @JsonIgnore
    private List<ProductionEnergy> productionEnergyList;

    @OneToMany(targetEntity = ConsumptionEnergy.class, fetch = FetchType.LAZY, mappedBy = "location")
    @JsonIgnore
    private List<ConsumptionEnergy> consumptionEnergyList;

    public Location() {
    }

    public Location(Integer id, String name, Integer year, String region, List<ProductionEnergy> productionEnergyList, List<ConsumptionEnergy> consumptionEnergyList) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.region = region;
        this.productionEnergyList = productionEnergyList;
        this.consumptionEnergyList = consumptionEnergyList;
    }

    public Location(Integer id, String name, Integer year, List<ProductionEnergy> productionEnergyList, List<ConsumptionEnergy> consumptionEnergyList) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.productionEnergyList = productionEnergyList;
        this.consumptionEnergyList = consumptionEnergyList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<ProductionEnergy> getProductionEnergyList() {
        return productionEnergyList;
    }

    public void setProductionEnergyList(List<ProductionEnergy> productionEnergyList) {
        this.productionEnergyList = productionEnergyList;
    }

    public List<ConsumptionEnergy> getConsumptionEnergyList() {
        return consumptionEnergyList;
    }

    public void setConsumptionEnergyList(List<ConsumptionEnergy> consumptionEnergyList) {
        this.consumptionEnergyList = consumptionEnergyList;
    }
}
