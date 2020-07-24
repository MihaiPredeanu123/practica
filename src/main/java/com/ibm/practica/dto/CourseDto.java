package com.ibm.practica.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class CourseDto {

    private Integer id;
    @NotEmpty
    private String name;
    @Positive
    private int year;
    @Positive
    private int credits;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
