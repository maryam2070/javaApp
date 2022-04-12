package com.example.aaaaaaaa;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProjectViewModel extends AndroidViewModel {
    private ProjectRepo repo;
    private LiveData<List<Notfication>>allNotifications;

    public ProjectViewModel(@NonNull Application application) {
        super(application);

        repo=new ProjectRepo(application);
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
