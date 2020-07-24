package com.ibm.practica.repository;

import com.ibm.practica.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByYear(int year);

    @Query("SELECT student " +
            "FROM Student student " +
            "WHERE student.name = :name")
    Optional<Student> findByName(String name);

    List<Student> findAllByFaculty_Name(String facultyName);

    @Query("SELECT student " +
            "FROM Student student " +
            "JOIN student.faculty faculty " +
            "WHERE faculty = :facultyName")
    List<Student> findAllStudentsByFacultyName(String facultyName);

    @Query("SELECT student " +
            "FROM Student student " +
            "JOIN student.courses course " +
            "WHERE course.name = :courseName")
    List<Student> findAllByCourseName(String courseName);
}
