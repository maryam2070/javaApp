package com.example.aaaaaaaa;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface NotficationDao {

    @Query("Select * FROM Notfication")
    LiveData<List<Notfication>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNotfictaion(Notfication notfication);

    @Query("DELETE FROM Notfication")
    void deleteAll();
}
