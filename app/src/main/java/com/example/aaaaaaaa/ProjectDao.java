package com.example.aaaaaaaa;

import android.database.Observable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourse(Courses course);

    @Query("Select * from courses")
    LiveData<List<Courses>>getAllCourses();

}
