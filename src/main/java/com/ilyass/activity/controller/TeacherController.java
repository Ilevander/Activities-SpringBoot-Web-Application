package com.ilyass.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ilyass.activity.models.Activity;
import com.ilyass.activity.models.Teacher;
import com.ilyass.activity.services.ActivityService;
import com.ilyass.activity.services.TeacherActivityService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private TeacherActivityService teacherActivityService;

    @GetMapping("/homepage")
    public String teacherHomePage(Model model) {
        // Fetch the currently authenticated teacher
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Teacher teacher = teacherActivityService.getTeacherByUsername(username);

        // Get activities for the fetched teacher
        List<Activity> activities = activityService.getAllActivitiesForTeacher(teacher);

        model.addAttribute("activities", activities);
        return "teacher_homepage";
    }


    @GetMapping("/createActivity")
    public String showCreateActivityForm(Model model) {
        model.addAttribute("activity", new Activity());
        return "create_activity";
    }

    @PostMapping("/saveActivity")
    public String saveActivity(@ModelAttribute Activity activity) {
        activityService.createActivity(activity);
        return "redirect:/teacher/homepage";
    }

}
