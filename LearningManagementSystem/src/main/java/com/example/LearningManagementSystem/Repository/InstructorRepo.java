package com.example.LearningManagementSystem.Repository;

import com.example.LearningManagementSystem.Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByEmail(String email);
    boolean existsByEmail(String email);
}
