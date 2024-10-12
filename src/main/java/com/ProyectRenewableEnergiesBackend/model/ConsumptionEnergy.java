package com.ProyectRenewableEnergiesBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ConsumptionEnergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeEnergy type_energy;
    private Double value;

    public ConsumptionEnergy() {
    }

    public ConsumptionEnergy(int id, TypeEnergy type_energy, Double value) {
        this.id = id;
        this.type_energy = type_energy;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeEnergy getType_energy() {
        return type_energy;
    }

    public void setType_energy(TypeEnergy type_energy) {
        this.type_energy = type_energy;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConsumptionEnergy{" +
                "id=" + id +
                ", type_energy=" + type_energy +
                ", value=" + value +
                '}';
    }
}
