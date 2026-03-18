package com.example.LearningManagementSystem.Listeners;

import com.example.LearningManagementSystem.Event.StudentCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener {

    @Async
    @EventListener
    public void handleStudentCreated(StudentCreatedEvent event) {
        System.out.println("Async task running for student: " + event.getStudentId());
    }
}
