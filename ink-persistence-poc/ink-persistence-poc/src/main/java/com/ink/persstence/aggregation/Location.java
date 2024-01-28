package com.ink.persstence.aggregation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Location {
    @Id
    private Long id;
    private String street;
    private long number;

    public Location() {}

    public Location(Long id, String street, long number) {
        this.id = id;
        this.street = street;
        this.number = number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }
}
