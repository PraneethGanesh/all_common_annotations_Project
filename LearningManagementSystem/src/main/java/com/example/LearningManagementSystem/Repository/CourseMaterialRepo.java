package com.example.LearningManagementSystem.Repository;

import com.example.LearningManagementSystem.Entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseMaterialRepo extends JpaRepository<CourseMaterial,Long> {

    List<CourseMaterial> findByCourse_CourseId(long courseId);
}
