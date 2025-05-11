package com.someware.budgie.backend.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Account extends PanacheEntity {
    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "description")
    public String description;
    @Column(name = "type", nullable = false)
    public String type;
    @Column(name = "balance", nullable = false)
    public double balance;
}

