package com.springapp.repository;

import com.springapp.model.Student;
import com.springapp.model.Subject;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Damqnov on 14-4-17.
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{

    @Query("SELECT s FROM Student s WHERE (s.facultyNumber) = (:facNumber)")
    public Student getStudentByFKNumber(@Param("facNumber") String facNumber);

    @Query("SELECT s.courseWork FROM Student s WHERE (s.facultyNumber) = (:facNumber)")
    public List<Subject> getCourseWorkSubject(@Param("facNumber") String facNumber);

    @Query("SELECT s.courseProject FROM Student s WHERE (s.facultyNumber) = (:facNumber)")
    public List<Subject> getCourseProjectSubject(@Param("facNumber") String facNumber);

}
