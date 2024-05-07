package com.ilyass.activity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ilyass.activity.models.Activity;
import com.ilyass.activity.models.Status;
import com.ilyass.activity.models.Student;
import com.ilyass.activity.repository.ActivityRepository;
import com.ilyass.activity.repository.StatusRepository;
import com.ilyass.activity.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Activity> getActivitiesForStudent(Student student) {
        return activityRepository.findByStudentsContains(student);
    }

    @Override
    public List<Activity> filterActivities(String semester, String subject, String status) {
        return activityRepository.findAllBySemesterAndSubjectAndStatus_StatusName(semester, subject, status);
    }

    @Transactional
    @Override
    public void markActivityAsRead(Activity activity) {
        Student student = activity.getStudents().iterator().next(); 
        Optional<Status> statusOptional = statusRepository.findByStudent(student);
        statusOptional.ifPresent(status -> {
            status.setRead(true);
            statusRepository.save(status);
        });
    }

    @Transactional
    @Override
    public void markActivityAsUnread(Activity activity) {
        Student student = activity.getStudents().iterator().next(); 
        Optional<Status> statusOptional = statusRepository.findByStudent(student);
        statusOptional.ifPresent(status -> {
            status.setRead(false);
            statusRepository.save(status);
        });
    }

    @Transactional
    @Override
    public void submitAssignment(Activity activity) {
        activity.getTypes().stream().filter(type -> "Work to be submitted".equals(type.getTypeName())).findFirst()
                .ifPresent(type -> {
                    type.setSubmitted(true);
                    activityRepository.save(activity);
                });
    }

    @Override
    public Activity getActivityById(Long activityId) {
        return activityRepository.findById(activityId).orElse(null);
    }
}
