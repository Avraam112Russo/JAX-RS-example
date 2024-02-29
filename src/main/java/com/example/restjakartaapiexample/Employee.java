package com.example.restjakartaapiexample;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    private String name;
    private int salary;

    public int getSalary() {
        return salary;
    }
    @XmlElement
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
}
