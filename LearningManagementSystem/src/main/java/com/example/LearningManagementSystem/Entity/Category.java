package com.example.LearningManagementSystem.Entity;

import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NonNull
    private String name;

    public Long getCategoryId() {
        return categoryId;
    }

    public @NonNull String getName() {
        return name;
    }


    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

}
