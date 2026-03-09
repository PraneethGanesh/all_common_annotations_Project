package com.example.LearningManagementSystem.Repository;

import com.example.LearningManagementSystem.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent_StudentId(Long studentId);
    List<Enrollment> findByCourse_CourseId(Long courseId);
    Optional<Enrollment> findByStudent_StudentIdAndCourse_CourseId(Long studentId, Long courseId);
    boolean existsByStudent_StudentIdAndCourse_CourseId(Long studentId, Long courseId);
}
