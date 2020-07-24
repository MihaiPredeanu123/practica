package com.ibm.practica.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Set;

public class StudentDto {

    private Integer id;
    @NotEmpty
    private String name;
    @Positive
    private int year;
    private FacultyDto faculty;
    private Set<CourseDto> courses;


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

    public FacultyDto getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDto faculty) {
        this.faculty = faculty;
    }

    public Set<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseDto> courses) {
        this.courses = courses;
    }
}
