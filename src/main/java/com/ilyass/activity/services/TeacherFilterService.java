package com.ilyass.activity.services;

import java.util.List;

import com.ilyass.activity.models.Activity;
import com.ilyass.activity.models.Teacher;

public interface TeacherFilterService {

	List<Activity> filterActivitiesBySemester(String semester, Teacher teacher);
    List<Activity> filterActivitiesBySubject(String subject, Teacher teacher);
    List<Activity> filterActivitiesByClass(String studentClass, Teacher teacher);
    List<Activity> filterActivitiesByGroup(String group, Teacher teacher);

}