package com.example.aaaaaaaa;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class NotficationViewModel extends AndroidViewModel {
    private NotificationRepository notificationRepository;
    private final LiveData<List<Notfication>>mAllNotfication;

    public NotficationViewModel(@NonNull Application application) {
        super(application);
        notificationRepository =new NotificationRepository(application);
        mAllNotfication= notificationRepository.getAll();
    }
    public void insert(Notfication notfication){
        notificationRepository.insert(notfication);
    }
    public LiveData<List<Notfication>> getAll(){
        return mAllNotfication;
    }
}
