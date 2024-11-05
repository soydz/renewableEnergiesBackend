package com.ProyectRenewableEnergiesBackend.DTO;

import com.ProyectRenewableEnergiesBackend.model.TypeEnergy;

public class ConsumptionEnergyRequest {
    private String country;
    private Integer year;

    private TypeEnergy typeEnergy;
    private Double value;

    public ConsumptionEnergyRequest() {
    }

    public ConsumptionEnergyRequest(String country, Integer year, TypeEnergy typeEnergy, Double value) {
        this.country = country;
        this.year = year;
        this.typeEnergy = typeEnergy;
        this.value = value;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
