package com.example.LearningManagementSystem.Repository;

import com.example.LearningManagementSystem.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Long, Course> {
}
