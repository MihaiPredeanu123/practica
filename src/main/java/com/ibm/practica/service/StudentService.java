package com.ibm.practica.service;

import com.ibm.practica.dto.StudentDto;
import com.ibm.practica.entity.Student;
import com.ibm.practica.mapper.StudentMapper;
import com.ibm.practica.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<StudentDto> getAllStudents() {
        List<Student> studentList = this.repository.findAll();
        List<StudentDto> studentDtoList = this.mapper.toDtoList(studentList);

        return studentDtoList;
    }

    public List<StudentDto> getAllStudentsFromYear(int year) {
        List<Student> studentList = this.repository.findAllByYear(year);
        List<StudentDto> studentDtoList = this.mapper.toDtoList(studentList);

        return studentDtoList;
    }

    public StudentDto getStudentByName(String name) {
        Optional<Student> studentOptional = this.repository.findByName(name);
        Student studentEntity = studentOptional.orElseThrow(() -> new IllegalArgumentException("There is no student with the given name."));
        StudentDto studentDto = this.mapper.toDto(studentEntity);

        return studentDto;
    }

    public List<StudentDto> getStudentsByFacultyName(String facultyName) {
        List<Student> studentList = this.repository.findAllByFaculty_Name(facultyName);
        List<StudentDto> studentDtoList = this.mapper.toDtoList(studentList);

        return studentDtoList;
    }

    public List<StudentDto> getStudentsByCourseName(String courseName) {
        List<Student> studentList = this.repository.findAllByCourseName(courseName);
        List<StudentDto> studentDtoList = this.mapper.toDtoList(studentList);

        return studentDtoList;
    }

    public StudentDto saveStudent(StudentDto studentDto) {
        Student newStudentEntity = this.mapper.toEntity(studentDto);
        Student savedStudentEntity = this.repository.save(newStudentEntity);
        StudentDto savedStudentDto = this.mapper.toDto(savedStudentEntity);

        return savedStudentDto;
    }

    public StudentDto updateStudent(StudentDto studentDto) {
        Optional<Student> existingStudentOptional = this.repository.findById(studentDto.getId());
        existingStudentOptional.orElseThrow(() -> new IllegalArgumentException("There is no student with the given id."));
        Student newStudentEntity = this.mapper.toEntity(studentDto);
        Student updatedStudentEntity = this.repository.save(newStudentEntity);
        StudentDto updatedStudentDto = this.mapper.toDto(updatedStudentEntity);

        return updatedStudentDto;
    }

    public void deleteStudentById(int id){
        this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no student with the given id."));
        this.repository.deleteById(id);
    }
}
