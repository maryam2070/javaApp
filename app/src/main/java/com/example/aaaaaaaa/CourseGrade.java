package com.example.aaaaaaaa;

public class CourseGrade {
    private String courseCode;
    private String courseGrade;
    private int courseCredit;
    private double coursePoints;

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public void setCoursePoints(double coursePoints) {
        this.coursePoints = coursePoints;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public double getCoursePoints() {
        return coursePoints;
    }
    public CourseGrade( String courseCode, String courseGrade, int courseCredit, double coursePoints) {

        this.courseCode = courseCode;
        this.courseGrade = courseGrade;
        this.courseCredit = courseCredit;
        this.coursePoints = coursePoints;


    }

}