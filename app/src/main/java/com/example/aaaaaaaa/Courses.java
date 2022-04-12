package com.example.aaaaaaaa;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity(tableName = "Courses")
public class Courses  implements Serializable {


    @NotNull
    @PrimaryKey
    private int idCourse;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
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

    public Character getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(Character courseGrade) {
        this.courseGrade = courseGrade;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public int getCoursePoints() {
        return coursePoints;
    }

    public void setCoursePoints(int coursePoints) {
        this.coursePoints = coursePoints;
    }

    @ColumnInfo(name="name")
    private String courseName;

    @ColumnInfo(name="code")
    private String courseCode;

    @ColumnInfo(name="grade")
    private Character courseGrade;

    @ColumnInfo(name="credit")
    private int courseCredit;

    @ColumnInfo(name="points")
    private int coursePoints;

    public Courses(String courseName, String courseCode, Character courseGrade, int courseCredit, int coursePoints) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseGrade = courseGrade;
        this.courseCredit = courseCredit;
        this.coursePoints = coursePoints;

    }
}


