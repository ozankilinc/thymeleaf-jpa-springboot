package com.ozan.thymeleafapp.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String avenue;
    @OneToOne
    @JoinTable(name="employee_address",joinColumns = @JoinColumn(name = "address_id"),
    inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Employee employee;

    public Address(){}

    public Address(String city, String avenue) {
        this.city = city;
        this.avenue = avenue;
    }

    public Address(String city, String avenue, Employee employee) {
        this.city = city;
        this.avenue = avenue;
        this.employee=employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", avenue='" + avenue + '\'' +
                '}';
    }
}
