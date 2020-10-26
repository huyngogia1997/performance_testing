package com.performance.testing.performance.repository;


import com.performance.testing.performance.model.Courses;
import com.performance.testing.performance.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Roles,Long> {
}
