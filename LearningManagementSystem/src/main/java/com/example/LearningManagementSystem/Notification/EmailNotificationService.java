package com.example.LearningManagementSystem.Notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService {

    @Override
    public void Notify(String message) {
        System.out.println("Email sent!!:" + message);
    }
}