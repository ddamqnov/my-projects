package com.springapp.service;

import com.springapp.model.Student;
import com.springapp.model.StudentView;
import com.springapp.model.Subject;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Damqnov on 14-4-17.
 */
public interface SubjectService {

    public List<Subject> getAllCourseWorkSubjects(String course,String speciality);
    public List<Subject> getAllCourseProjectSubjects(String course,String speciality);

    public List<String> getAllCourseWorkSubjectNames(String course,String speciality);
    public List<String> getAllCourseProjectSubjectNames(String course,String speciality);

    public Subject getSubjectByName(String subjectName);

    public List<String> getSubjectsBySpecialityAndCourse(String course,String speciality) ;



}

