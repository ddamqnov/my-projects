package com.springapp.model;

/**
 * Created by Damqnov on 14-4-29.
 */
public class StatsSubjectView {

    private String name;
    private boolean courseWork;
    private boolean courseProject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCourseWork() {
        return courseWork;
    }

    public void setCourseWork(boolean courseWork) {
        this.courseWork = courseWork;
    }

    public boolean isCourseProject() {
        return courseProject;
    }

    public void setCourseProject(boolean courseProject) {
        this.courseProject = courseProject;
    }
}
