package com.ibm.practica.repository;

import com.ibm.practica.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAllByCreditsGreaterThan(int credits);

    @Query("SELECT course " +
            "FROM Course course " +
            "WHERE course.credits > :credits")
    List<Course> findCoursesOverCredits(int credits);
}
