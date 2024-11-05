package com.ProyectRenewableEnergiesBackend.model;

import jakarta.persistence.*;

@Entity
public class ProductionEnergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeEnergy typeEnergy;
    private Double value;

    @ManyToOne(targetEntity = Location.class)
    private Location location;

    public ProductionEnergy() {
    }

    public ProductionEnergy(Integer id, TypeEnergy typeEnergy, Double value, Location location) {
        this.id = id;
        this.typeEnergy = typeEnergy;
        this.value = value;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
