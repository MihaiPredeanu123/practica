package com.ibm.practica.mapper;

import com.ibm.practica.dto.FacultyDto;
import com.ibm.practica.entity.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {

    public FacultyDto toDto(Faculty entity) {
        FacultyDto dto = new FacultyDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public Faculty toEntity(FacultyDto dto) {
        Faculty entity = new Faculty();

        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }
}
