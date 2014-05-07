package com.springapp.controller;

import com.springapp.model.*;
import com.springapp.model.Error;
import com.springapp.service.StudentService;
import com.springapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damqnov on 14-4-17.
 */
@Controller
public class CourseProjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    private enum CourseExercise {WORK,PROJECT};
    CourseExercise courseExercise = null;

    @RequestMapping(value = "/project/all", method = RequestMethod.GET)
    public @ResponseBody List<String> getProjectSubjects(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            Student student = studentService.getStudentByFK(auth.getName());
            List<String> subjectNames = subjectService.getAllCourseProjectSubjectNames(Integer.toString(student.getCourse()),student.getSpeciality());
            return subjectNames;
        }
    return null;
    }

    @RequestMapping(value = "/work/all", method = RequestMethod.GET)
    public @ResponseBody List<String> getWorkSubjects(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            Student student = studentService.getStudentByFK(auth.getName());
            List<String> subjectNames = subjectService.getAllCourseWorkSubjectNames(Integer.toString(student.getCourse()), student.getSpeciality());
            return subjectNames;
        }
        return null;
    }


    @RequestMapping(value = "/project/existing", method = RequestMethod.GET)
    public @ResponseBody List<String> getPWInformation(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            List<String> stringList = new ArrayList<String>();
            List<Subject> courseWork = studentService.getCourseWorkSubject(userName);
            List<Subject> projectWork = studentService.getCourseProjectSubject(userName);

            if(courseWork.isEmpty() == false){
                stringList.add(courseWork.get(0).getName());
            }else{
                stringList.add("null");
            }
            if(projectWork.isEmpty() == false){
                stringList.add(projectWork.get(0).getName());
            }else{
                stringList.add("null");
            }

            return  stringList;
        }
        return null;
    }


    @RequestMapping(value = "/project/courseproject/save" , headers = "Content-Type=application/json")
    public @ResponseBody Error saveProject(@RequestBody ProjectRequest projectRequest){
        courseExercise =  CourseExercise.PROJECT ;
        return  saveSubjectsInformation(courseExercise,projectRequest);
    }

    @RequestMapping(value = "/project/coursework/save" , headers = "Content-Type=application/json")
    public @ResponseBody Error saveWork(@RequestBody ProjectRequest projectRequest){
        courseExercise =  CourseExercise.WORK ;
        return  saveSubjectsInformation(courseExercise,projectRequest);
    }

    public com.springapp.model.Error saveSubjectsInformation(CourseExercise type , ProjectRequest projectRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            Student student = studentService.getStudentByFK(userName);
            Subject firstSubject = subjectService.getSubjectByName(projectRequest.getFirst());
            Subject secondSubject = subjectService.getSubjectByName(projectRequest.getSecond());
            Subject thirdSubject = subjectService.getSubjectByName(projectRequest.getThird());
            List<Subject> allSubjects = new ArrayList<Subject>();
            allSubjects.add(firstSubject);
            allSubjects.add(secondSubject);
            allSubjects.add(thirdSubject);

            switch (courseExercise){
                case WORK :
                    student.setCourseWork(allSubjects);
                    break;
                case PROJECT:
                    student.setCourseProject(allSubjects);
                    break;
            }

            studentService.updateStudent(student);

            return null;
        }
        return new Error("Operation failure !");
    }
}




