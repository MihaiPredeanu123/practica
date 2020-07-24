package com.ibm.practica.mapper;

import com.ibm.practica.dto.CourseDto;
import com.ibm.practica.entity.Course;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CourseMapper {

    public CourseDto toDto(Course entity){
        CourseDto dto = new CourseDto();

        dto.setId(entity.getId());
        dto.setCredits(entity.getCredits());
        dto.setName(entity.getName());
        dto.setYear(entity.getYear());

        return dto;
    }

    public Course toEntity(CourseDto dto){
        Course entity = new Course();

        entity.setId(dto.getId());
        entity.setCredits(dto.getCredits());
        entity.setName(dto.getName());
        entity.setYear(dto.getYear());

        return entity;
    }

    public Set<CourseDto> toDtoSet(Set<Course> courseSet){
        Set<CourseDto> dtoSet = new HashSet<>();

        courseSet.forEach(courseEntity -> {
            dtoSet.add(toDto(courseEntity));
        });

        return dtoSet;
    }

    public Set<Course> toEntitySet(Set<CourseDto> courseDtoSet){
        Set<Course> entitySet = new HashSet<>();

        courseDtoSet.forEach(courseDto -> {
            entitySet.add(toEntity(courseDto));
        });

        return entitySet;
    }

}
