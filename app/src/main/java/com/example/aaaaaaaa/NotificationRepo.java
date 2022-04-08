package com.example.aaaaaaaa;

import static android.widget.Toast.LENGTH_SHORT;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;
import java.util.UUID;

public class NotificationRepo {
    private NotficationDao dao;
    private LiveData<List<Notfication>>notifications;

    public NotificationRepo(Application application){
        NotificationDatabase database=NotificationDatabase.getDatabase(application);
        dao= database.notficationDao();
        notifications=dao.getAll();
    }
    public void insert(Notfication notfication){
        NotificationDatabase.databaseWriteExecutor.execute(() -> {
            dao.insertNotfictaion(notfication);
        });

    }
    public void deleteAll(){
        NotificationDatabase.databaseWriteExecutor.execute(() -> {
            dao.deleteAll();
        });

    }
    public LiveData<List<Notfication>>getAllNotifications()
    {
        return notifications;
    }



}
