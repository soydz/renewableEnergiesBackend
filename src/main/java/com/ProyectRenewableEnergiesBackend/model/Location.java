package com.ProyectRenewableEnergiesBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToMany(targetEntity = ProductionEnergy.class, fetch = FetchType.LAZY, mappedBy = "location")
    @JsonBackReference // evitar el problema de anidación en la serialización
    private List<ProductionEnergy> productionList;

    @OneToMany(targetEntity = ConsumptionEnergy.class, fetch = FetchType.LAZY, mappedBy = "location")
    @JsonBackReference //evitar el problema de anidación en la serialización
    private List<ConsumptionEnergy> consumptionList;

    public Location() {
    }

    public Location(int id, String name, Integer year, List<ProductionEnergy> productionList, List<ConsumptionEnergy> consumptionList) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.productionList = productionList;
        this.consumptionList = consumptionList;
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

    public List<ProductionEnergy> getProductionList() {
        return productionList;
    }

    public void setProductionList(List<ProductionEnergy> productionList) {
        this.productionList = productionList;
    }

    public List<ConsumptionEnergy> getConsumptionList() {
        return consumptionList;
    }

    public void setConsumptionList(List<ConsumptionEnergy> consumptionList) {
        this.consumptionList = consumptionList;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", productionList=" + productionList +
                ", consumptionList=" + consumptionList +
                '}';
    }
}
