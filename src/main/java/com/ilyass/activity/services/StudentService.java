package com.ilyass.activity.services;

import com.ilyass.activity.models.Activity;
import com.ilyass.activity.models.Student;


import java.util.List;

public interface StudentService {
    List<Activity> getActivitiesForStudent(Student student);

    List<Activity> filterActivities(String semester, String subject, String status);

    void markActivityAsRead(Activity activity);

    void markActivityAsUnread(Activity activity);

    void submitAssignment(Activity activity);

    Activity getActivityById(Long activityId);
} 