package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="Driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String license_id;
    @Column(name="name")
    private String name;
    @Column(name="License_Number")
    private String license_Number;

    public String getLicense_id() {
        return license_id;
    }

    public void setLicense_id(String license_id) {
        this.license_id = license_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense_Number() {
        return license_Number;
    }

    public void setLicense_Number(String license_Number) {
        this.license_Number = license_Number;
    }

    public Driver(String license_id, String name, String license_Number) {
        this.license_id = license_id;
        this.name = name;
        this.license_Number = license_Number;


    }

    @Override
    public String toString() {
        return "Driver{" +
                "license_id='" + license_id + '\'' +
                ", name='" + name + '\'' +
                ", license_Number='" + license_Number + '\'' +
                '}';
    }
}
