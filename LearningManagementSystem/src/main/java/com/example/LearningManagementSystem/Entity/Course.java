package com.example.LearningManagementSystem.Entity;

import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;

import java.time.LocalDateTime;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @NonNull
    private String courseName;
    private String description;
    private LocalDateTime created_at;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public Long getCourseId() {
        return courseId;
    }

    public @NonNull String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCourseName(@NonNull String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }


    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
