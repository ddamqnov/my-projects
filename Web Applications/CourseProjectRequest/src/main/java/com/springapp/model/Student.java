package com.springapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Damqnov on 14-4-17.
 */

@Entity
public class Student {

   @GeneratedValue
   @Id
   private Integer Id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String surName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private int course;

    @NotEmpty
    private int studentGroup;

    @NotEmpty
    private String faculty;

    @NotEmpty
    private String facultyNumber;

    @NotEmpty
    private String speciality;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course_subject",
            joinColumns = {@JoinColumn(name="student_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="subject_id", referencedColumnName="id")}
    )
    private List<Subject> courseWork;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_project_subject",
            joinColumns = {@JoinColumn(name="student_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="subject_id", referencedColumnName="id")}
    )
    private List<Subject> courseProject;

    public List<Subject> getCourseWork() {
        return courseWork;
    }

    public void setCourseWork(List<Subject> courseWork) {
        this.courseWork = courseWork;
    }

    public List<Subject> getCourseProject() {
        return courseProject;
    }

    public void setCourseProject(List<Subject> courseProject) {
        this.courseProject = courseProject;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(int studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}
