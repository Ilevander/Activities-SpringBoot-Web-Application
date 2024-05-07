package com.ilyass.activity.services;

import com.ilyass.activity.models.Teacher;

import java.util.List;

import com.ilyass.activity.models.Activity;

public interface TeacherActivityService {

    List<Activity> getAllActivitiesForTeacher(Teacher teacher);

    Activity createActivity(Activity activity);

    Activity updateActivity(Activity activity);

    void deleteActivity(Long activityId);
}
