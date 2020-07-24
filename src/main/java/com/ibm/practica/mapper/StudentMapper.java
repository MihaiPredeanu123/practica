package com.ibm.practica.mapper;

import com.ibm.practica.dto.StudentDto;
import com.ibm.practica.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    private CourseMapper courseMapper;
    private FacultyMapper facultyMapper;

    public StudentDto toDto(Student entity) {
        StudentDto dto = new StudentDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setYear(entity.getYear());
        dto.setFaculty(facultyMapper.toDto(entity.getFaculty()));
        dto.setCourses(courseMapper.toDtoSet(entity.getCourses()));

        return dto;
    }

    public Student toEntity(StudentDto dto){
        Student entity = new Student();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setYear(dto.getYear());
        entity.setFaculty(facultyMapper.toEntity(dto.getFaculty()));
        entity.setCourses(courseMapper.toEntitySet(dto.getCourses()));


        return entity;
    }

    public List<StudentDto> toDtoList(List<Student> entityList){
        List<StudentDto> dtoList = new ArrayList<>();

        entityList.forEach(entity -> {
            dtoList.add(toDto(entity));
        });

        return dtoList;
    }

    public List<Student> toEntityList(List<StudentDto> dtoList){
        List<Student> entityList = new ArrayList<>();

        dtoList.forEach(dto -> {
            entityList.add(toEntity(dto));
        });

        return entityList;
    }

    @Autowired
    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Autowired
    public void setFacultyMapper(FacultyMapper facultyMapper) {
        this.facultyMapper = facultyMapper;
    }
}
