package com.ink.persstence.aggregation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="ink_user")
public class InkUser {

    @Id
    private Long id;
    private String email;
    @Column(name = "first_name")
    private String fisrstName;
    @Column(name = "surname_name")
    private String surnameName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private int status;

    public InkUser() {}

    public InkUser(Long id, String email, String fisrstName, String surnameName, String lastName, Date dateOfBirth, int status) {
        this.id = id;
        this.email = email;
        this.fisrstName = fisrstName;
        this.surnameName = surnameName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFisrstName() {
        return fisrstName;
    }

    public void setFisrstName(String fisrstName) {
        this.fisrstName = fisrstName;
    }

    public String getSurnameName() {
        return surnameName;
    }

    public void setSurnameName(String surnameName) {
        this.surnameName = surnameName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
