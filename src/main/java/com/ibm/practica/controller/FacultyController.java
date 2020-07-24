package com.ibm.practica.controller;

import com.ibm.practica.dto.FacultyDto;
import com.ibm.practica.service.FacultyService;
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
@RequestMapping("/faculties")
@Validated
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacultyDto> createFaculty(@Valid @RequestBody FacultyDto newFacultyDto) {
        FacultyDto createdFacultyDto = this.facultyService.saveFaculty(newFacultyDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdFacultyDto);
    }

}
