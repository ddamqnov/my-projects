package com.springapp.controller;

import com.springapp.model.StatsSubjectView;
import com.springapp.model.Student;
import com.springapp.model.StudentView;
import com.springapp.model.Subject;
import com.springapp.repository.SpecialityRepository;
import com.springapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Damqnov on 14-4-28.
 */
@Controller
public class StatisticController {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/statistic" , method = RequestMethod.GET)
    public String showStatistic (){
        return "statistic";
    }

    @RequestMapping(value = "/speciality/all/name" , method = RequestMethod.GET)
    public @ResponseBody List<String> showFacultyNames (){
        return specialityRepository.getAllSpecialityNames();
    }

    @RequestMapping(value = "/subject/name/speciality+course" , method = RequestMethod.GET)
    public @ResponseBody List<String> getSubjectsBySpecialityAndCourse (){
        return subjectService.getSubjectsBySpecialityAndCourse("КСТ","3");
    }

    @RequestMapping(value = "/subject/name/speciality+course" , method = RequestMethod.POST)
    public @ResponseBody List<String> getSubjectsBySpecialityAndCourse2 (@RequestBody Subject subject){
        return subjectService.getSubjectsBySpecialityAndCourse(subject.getSpeciality(), subject.getCourse());
    }


    @RequestMapping(value = "/subject/type" , method = RequestMethod.POST)
    public @ResponseBody List<String> getSubjectTypes (@RequestBody Subject subject){
        Subject sub = subjectService.getSubjectByName(subject.getName());
        ArrayList<String> arrayList = new ArrayList<String>();

        if(sub.isCourseProject() && sub.isCourseWork()){
            arrayList.add("Всички");
            arrayList.add("Курсова работа");
            arrayList.add("Курсова проект");
        }
        else {
            if(sub.isCourseProject()){
                arrayList.add("Курсова проект");
            }
            else {
                if(sub.isCourseWork()){
                    arrayList.add("Курсова работа");
                }
            }
        }
        return arrayList;
    }
}
