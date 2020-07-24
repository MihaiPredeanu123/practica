package com.ibm.practica.service;

import com.ibm.practica.dto.CourseDto;
import com.ibm.practica.entity.Course;
import com.ibm.practica.mapper.CourseMapper;
import com.ibm.practica.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;

    public CourseService(CourseRepository repository, CourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CourseDto saveCourse(CourseDto courseDto) {
        Course newCourseEntity = this.mapper.toEntity(courseDto);
        Course savedCourseEntity = this.repository.save(newCourseEntity);
        CourseDto savedCourseDto = this.mapper.toDto(savedCourseEntity);

        return savedCourseDto;
    }
}
