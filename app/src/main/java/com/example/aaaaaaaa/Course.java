
package com.example.aaaaaaaa;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int idCourse;
    private String courseName;
    private String courseCode;
    private String courseGrade;
    private int courseCredit;
    private double coursePoints;

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public double getCoursePoints() {
        return coursePoints;
    }

    public void setCoursePoints(double coursePoints) {
        this.coursePoints = coursePoints;
    }

    public Course(String courseName, String courseCode, String courseGrade, int courseCredit, double coursePoints) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseGrade = courseGrade;
        this.courseCredit = courseCredit;
        this.coursePoints = coursePoints;


    }
}

