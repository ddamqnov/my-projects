package com.springapp.service;

import com.springapp.model.Student;
import com.springapp.model.Subject;
import com.springapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Damqnov on 14-4-21.
 */

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentByFK(String fakNumber) {
        return studentRepository.getStudentByFKNumber(fakNumber);
    }

    @Override
    public List<Subject> getCourseWorkSubject(String fakNumber) {
        return studentRepository.getCourseWorkSubject(fakNumber);
    }

    @Override
    public List<Subject> getCourseProjectSubject(String fakNumber) {
        return studentRepository.getCourseProjectSubject(fakNumber);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }


}

