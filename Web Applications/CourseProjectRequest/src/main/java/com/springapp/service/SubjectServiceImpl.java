package com.springapp.service;

import com.springapp.model.Student;
import com.springapp.model.StudentView;
import com.springapp.model.Subject;
import com.springapp.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Damqnov on 14-4-17.
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllCourseWorkSubjects(String course, String speciality) {
        return subjectRepository.getAllCourseWorkSubjects(course,speciality);
    }

    @Override
    public List<Subject> getAllCourseProjectSubjects(String course, String speciality) {
        return subjectRepository.getAllCourseProjectSubjects(course,speciality);
    }

    @Override
    public List<String> getAllCourseWorkSubjectNames(String course, String speciality) {
        return subjectRepository.getAllCourseWorkSubjectsNames(course,speciality);
    }

    @Override
    public List<String> getAllCourseProjectSubjectNames(String course, String speciality) {
        return subjectRepository.getAllCourseProjectSubjectsNames(course,speciality);
    }

    @Override
    public Subject getSubjectByName(String subjectName) {
        return subjectRepository.getSubjectByName(subjectName);
    }

    @Override
    public List<String> getSubjectsBySpecialityAndCourse(String speciality, String course) {
        return subjectRepository.getAllByCourseAndSpeciality(course,speciality);
    }

}

