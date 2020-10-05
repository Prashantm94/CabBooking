package com.example.demo.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id ;
    @Column(name ="Name")
    private String name ;
    @Column(name="Address")
    private String address;
    @Column(name="bookingHistory")
    private String bookingDetails;

    public Rider(String id, String name, String address,String bookingDetails) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.bookingDetails=bookingDetails;
    }

    public <T> Rider(List<T> asList) {
    }

    public String getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(Optional<Driver> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
