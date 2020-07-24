package com.ibm.practica.controller;

import com.ibm.practica.dto.CourseDto;
import com.ibm.practica.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
@Validated
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseDto newCourseDto) {
        CourseDto createdCourseDto = this.courseService.saveCourse(newCourseDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdCourseDto);
    }
}
