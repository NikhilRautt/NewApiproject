package com.atmsite_approval.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atmsite") // Ensure the table name matches your database table
public class Atmsite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SrNO", nullable = false)
    private Long id;

    @Column(name = "frId", nullable = false) // Match the exact column name
    private String frId;

    @Column(name = "frlat", nullable = false) // Match the exact column name
    private String frlat;

    @Column(name = "frlong", nullable = false)
    private String frlong;

    @Column(name = "isatmnear", nullable = false)
    private String isatmnear;

    @Column(name = "isatmsuccessfull", nullable = false)
    private String isatmsuccessfull;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrId() {
        return frId;
    }

    public void setFrId(String frId) {
        this.frId = frId;
    }

    public String getFrlat() {
        return frlat;
    }

    public void setFrlat(String frlat) {
        this.frlat = frlat;
    }

    public String getFrlong() {
        return frlong;
    }

    public void setFrlong(String frlong) {
        this.frlong = frlong;
    }

    public String getIsatmnear() {
        return isatmnear;
    }

    public void setIsatmnear(String isatmnear) {
        this.isatmnear = isatmnear;
    }

    public String getIsatmsuccessfull() {
        return isatmsuccessfull;
    }

    public void setIsatmsuccessfull(String isatmsuccessfull) {
        this.isatmsuccessfull = isatmsuccessfull;
    }
}

