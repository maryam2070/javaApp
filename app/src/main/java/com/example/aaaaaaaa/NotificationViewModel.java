package com.example.aaaaaaaa;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotificationViewModel extends AndroidViewModel {
    private NotificationRepo repo;
    private LiveData<List<Notfication>>allNotifications;

    public NotificationViewModel(@NonNull Application application) {
        super(application);

        repo=new NotificationRepo(application);
        allNotifications= repo.getAllNotifications();
    }
    public void insert(Notfication notfication)
    {
        System.out.println("Viewmodel insert              ");
        repo.insert(notfication);
    }
    public void deleteAll()
    {
        repo.deleteAll();
    }
    public LiveData<List<Notfication>>getAllNotifications(){
        return allNotifications;
    }
}
