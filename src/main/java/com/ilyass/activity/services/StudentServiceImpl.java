package com.ilyass.activity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ilyass.activity.models.Activity;
import com.ilyass.activity.models.Student;
import com.ilyass.activity.repository.ActivityRepository;
import com.ilyass.activity.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Activity> getActivitiesForStudent(Student student) {
        return activityRepository.findByStudent(student);
    }

    @Override
    public List<Activity> filterActivities(String semester, String subject, String status) {
        // Implement filtering logic based on semester, subject, and status
        return activityRepository.findAllBySemesterAndSubjectAndStatus(semester, subject, status);
    }

    @Transactional
    @Override
    public void markActivityAsRead(Activity activity) {
        // Implement logic to mark activity as read	
        activity.setRead(true);
        activityRepository.markActivityAsRead(activity);
    }

    @Transactional
    @Override
    public void markActivityAsUnread(Activity activity) {
        // Implement logic to mark activity as unread
        activity.setRead(false);
        activityRepository.markActivityAsUnread(activity);
    }

    @Transactional
    @Override
    public void submitAssignment(Activity activity) {
        // Implement logic to submit assignment
        activity.setSubmitted(true);
        activityRepository.save(activity);
    }

    @Override
    public Activity getActivityById(Long activityId) {
        return activityRepository.findById(activityId).orElse(null);
    }
}
