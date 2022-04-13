package com.example.aaaaaaaa;

import android.database.Observable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjectDao {

    @Query("Select * FROM Notfication")
    LiveData<List<Notfication>> getAllNotifications();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNotfictaion(Notfication notfication);

    @Query("DELETE FROM Notfication")
    void deleteAll();

    /*-----------------------------------------------------------*/

    @Insert
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    @Query("SELECT * FROM course_table")
    LiveData<List<Course>> getAllCourses();
}
