package com.performance.testing.performance.repository;


import com.performance.testing.performance.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses,Long> {
}
