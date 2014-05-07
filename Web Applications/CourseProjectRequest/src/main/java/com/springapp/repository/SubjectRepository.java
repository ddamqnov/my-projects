package com.springapp.repository;

import com.springapp.model.Student;
import com.springapp.model.StudentView;
import com.springapp.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Damqnov on 14-4-17.
 */
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    @Query("SELECT s FROM Subject s WHERE (s.course) = (:course) and s.speciality = (:speciality) and s.CourseWork = 1 ")
    public List<Subject> getAllCourseWorkSubjects(@Param("course") String course , @Param("speciality") String speciality);

    @Query("SELECT s FROM Subject s WHERE (s.course) = (:course) and s.speciality = (:speciality) and s.CourseProject = 1 ")
    public List<Subject> getAllCourseProjectSubjects(@Param("course") String course , @Param("speciality") String speciality);

    @Query("SELECT s.name FROM Subject s WHERE (s.course) = (:course) and s.speciality = (:speciality) and s.CourseWork = 1 ")
    public List<String> getAllCourseWorkSubjectsNames(@Param("course") String course , @Param("speciality") String speciality);

    @Query("SELECT s.name FROM Subject s WHERE (s.course) = (:course) and s.speciality = (:speciality) and s.CourseProject = 1 ")
    public List<String> getAllCourseProjectSubjectsNames(@Param("course") String course , @Param("speciality") String speciality);

    @Query ("SELECT s FROM Subject s WHERE (s.name) = (:subjectName)")
    public Subject getSubjectByName(@Param("subjectName") String subjectName);

    @Query("SELECT s.name FROM Subject s WHERE (s.course) = (:course) and s.speciality = (:speciality)")
    public List<String> getAllByCourseAndSpeciality(@Param("course") String course , @Param("speciality") String speciality);

    @Query ("SELECT s.courseStudentList FROM Subject s WHERE (s.name) = :name ")
    public List<Student> getAllStudentsByCourseWork(@Param("name") String name);

    @Query ("SELECT s.projectStudentList FROM Subject s WHERE (s.name) = :name ")
    public List<Student> getAllStudentsByCourseProject(@Param("name") String name);


}