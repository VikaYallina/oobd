package com.example.demo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Provider{
    @Id
    private Long id;
    @Column
    private String companyName;
    @Column
    private String town;
    @Column
    private String email;

    public Provider(String name, String town, String email){
        this.companyName = name;
        this.email = email;
        this.town = town;
    }

    public Provider() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return "Provider: " + getCompanyName() +
                ", email=" + getEmail() +
                ", town=" + getTown() +
                '\n';
    }
}
