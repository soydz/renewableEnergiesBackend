package com.ProyectRenewableEnergiesBackend.DTO;

import com.ProyectRenewableEnergiesBackend.model.TypeEnergy;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EnergyDTO {
    @Id
    Integer id;
    String country;
    Integer year;
    TypeEnergy typeEnergy;
    double production;
    double consumption;

    public EnergyDTO() {
    }

    public EnergyDTO(String country, Integer year, TypeEnergy typeEnergy, double production, double consumption) {
        this.country = country;
        this.year = year;
        this.typeEnergy = typeEnergy;
        this.production = production;
        this.consumption = consumption;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public TypeEnergy getTypeEnergy() {
        return typeEnergy;
    }

    public void setTypeEnergy(TypeEnergy typeEnergy) {
        this.typeEnergy = typeEnergy;
    }

    public double getProduction() {
        return production;
    }

    public void setProduction(double production) {
        this.production = production;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}
