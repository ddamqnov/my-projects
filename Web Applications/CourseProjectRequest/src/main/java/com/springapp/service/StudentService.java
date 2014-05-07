package com.springapp.service;


import com.springapp.model.Student;
import com.springapp.model.Subject;

import java.util.List;

/**
 * Created by Damqnov on 14-4-21.
 */
public interface StudentService {

    public Student getStudentByFK(String fakNumber);
    public List<Subject> getCourseWorkSubject(String fakNumber);
    public List<Subject> getCourseProjectSubject(String fakNumber);

    public Student updateStudent(Student student);
}
