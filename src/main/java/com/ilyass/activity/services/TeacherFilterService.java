package com.ilyass.activity.services;

import java.util.List;

import com.ilyass.activity.models.Activity;
public interface TeacherFilterService {

    List<Activity> filterActivities(String semester, String subject, String classGroup);

}