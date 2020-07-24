package com.ibm.practica.service;

import com.ibm.practica.dto.FacultyDto;
import com.ibm.practica.entity.Faculty;
import com.ibm.practica.mapper.FacultyMapper;
import com.ibm.practica.repository.FacultyRepository;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    private final FacultyRepository repository;
    private final FacultyMapper mapper;

    public FacultyService(FacultyRepository repository, FacultyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public FacultyDto saveFaculty(FacultyDto facultyDto) {
        Faculty newFacultyEntity = this.mapper.toEntity(facultyDto);
        Faculty savedFacultyEntity = this.repository.save(newFacultyEntity);
        FacultyDto savedFacultyDto = this.mapper.toDto(savedFacultyEntity);

        return savedFacultyDto;
    }
}
