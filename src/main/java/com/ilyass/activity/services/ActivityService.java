package com.ilyass.activity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyass.activity.models.Activity;
import com.ilyass.activity.models.Student;
import com.ilyass.activity.models.Teacher;
import com.ilyass.activity.repository.ActivityRepository;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivitiesForTeacher(Teacher teacher) {
        return activityRepository.findAllByTeacher(teacher);
    }

//    public List<Activity> getAllActivitiesForStudent(Student student) {
//        // Assuming Student class has getStudentClass() and getTeacher() methods
//        return activityRepository.findAllByStudentClassAndTeacher(student.getStudentClass(), student.getTeacher());
//    }

    public void createActivity(Activity activity) {
        activityRepository.save(activity);
    }

    public void updateActivity(Activity activity) {
        activityRepository.save(activity);
    }

    public void deleteActivity(Long activityId) {
        activityRepository.deleteById(activityId);
    }

    public Activity getActivityById(Long activityId) {
        return activityRepository.findById(activityId).orElse(null);
    }
}
