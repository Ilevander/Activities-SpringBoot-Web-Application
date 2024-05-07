package com.ilyass.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ilyass.activity.services.;
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/homepage")
    public String teacherHomePage(Model model) {
        List<Activity> activities = activityService.getAllActivities();
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