package com.springapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Damqnov on 14-4-17.
 */

@Entity
public class Subject {

    @GeneratedValue
    @javax.persistence.Id
    private Integer Id;

    @NotEmpty
    @Column(unique = true)
    private String name;

    @NotEmpty
    private String course;

    @NotEmpty
    private String speciality;

    @NotEmpty
    private boolean CourseWork;

    @NotEmpty
    private boolean CourseProject;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_project_subject",
            joinColumns = {@JoinColumn(name="subject_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="student_id", referencedColumnName="id")}
    )
    private List<Student> projectStudentList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course_subject",
            joinColumns = {@JoinColumn(name="subject_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="student_id", referencedColumnName="id")}
    )
    private List<Student> courseStudentList;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public boolean isCourseWork() {
        return CourseWork;
    }

    public void setCourseWork(boolean courseWork) {
    CourseWork = courseWork;
}

    public boolean isCourseProject() {
        return CourseProject;
    }

    public void setCourseProject(boolean courseProject) {
        CourseProject = courseProject;
    }

    public List<Student> getProjectStudentList() {
        return projectStudentList;
    }

    public void setProjectStudentList(List<Student> projectStudentList) {
        this.projectStudentList = projectStudentList;
    }

    public List<Student> getCourseStudentList() {
        return courseStudentList;
    }

    public void setCourseStudentList(List<Student> courseStudentList) {
        this.courseStudentList = courseStudentList;
    }
}
