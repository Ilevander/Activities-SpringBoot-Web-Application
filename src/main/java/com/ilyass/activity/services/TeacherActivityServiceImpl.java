package com.ilyass.activity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyass.activity.models.Teacher;
import com.ilyass.activity.repository.ActivityRepository;
import com.ilyass.activity.models.Activity;

@Service
public class TeacherActivityServiceImpl implements TeacherActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public TeacherActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> getAllActivitiesForTeacher(Teacher teacher) {
        return activityRepository.findAllByTeacher(teacher);
    }

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(Long activityId) {
        activityRepository.deleteById(activityId);
    }
}
