package com.ilyass.activity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyass.activity.models.Activity;
import com.ilyass.activity.models.Teacher;
import com.ilyass.activity.repository.ActivityRepository;

@Service
public class TeacherFilterServiceImpl implements TeacherFilterService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public List<Activity> filterActivitiesBySemester(String semester, Teacher teacher) {
        return activityRepository.findAllBySemesterAndTeacher(semester, teacher);
    }

    @Override
    public List<Activity> filterActivitiesBySubject(String subject, Teacher teacher) {
        return activityRepository.findAllBySubjectAndTeacher(subject, teacher);
    }

    @Override
    public List<Activity> filterActivitiesByClass(String studentClass, Teacher teacher) {
        return activityRepository.findAllByStudentClassAndTeacher(studentClass, teacher);
    }

    @Override
    public List<Activity> filterActivitiesByGroup(String group, Teacher teacher) {
        return activityRepository.findAllByGroupAndTeacher(group, teacher);
    }

}
