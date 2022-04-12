package com.example.aaaaaaaa;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
///////////
public class ProjectRepo {
    private ProjectDao dao;
    private LiveData<List<Notfication>>notifications;//

    public ProjectRepo(Application application){
        ProjectDatabase database= ProjectDatabase.getDatabase(application);
        dao= database.Dao();
        notifications=dao.getAllNotifications();
    }
    public void insert(Notfication notfication){
        ProjectDatabase.databaseWriteExecutor.execute(() -> {
            dao.insertNotfictaion(notfication);
        });

    }
    public void deleteAll(){
        ProjectDatabase.databaseWriteExecutor.execute(() -> {
            dao.deleteAll();
        });

    }
    public LiveData<List<Notfication>>getAllNotifications()
    {
        return notifications;
    }

/*___________________________________________*/


}
