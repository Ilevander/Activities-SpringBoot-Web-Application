package com.ilyass.activity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilyass.activity.models.Activity;
import com.ilyass.activity.models.Teacher;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findAllByTypeAndTeacher_Id(String type, Long teacherId);

    List<Activity> findAllByTypeAndSemesterAndSubjectAndClassGroup(String type, String semester, String subject, String classGroup);

    List<Activity> findAllByTeacher(Teacher teacher);

    List<Activity> findAllBySemesterAndTeacher(String semester, Teacher teacher);

    List<Activity> findAllBySubjectAndTeacher(String subject, Teacher teacher);

    List<Activity> findAllByStudentClassAndTeacher(String studentClass, Teacher teacher);

    List<Activity> findAllByGroupAndTeacher(String group, Teacher teacher);
}
