package com.example.aaaaaaaa;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotificationRepository {
    private NotficationDao notficationDao;
    private LiveData<List<Notfication>>mAllNotification;

    NotificationRepository(Application application)
    {
        NotificationDatabase db=NotificationDatabase.getDatabase(application);
        notficationDao=db.notficationDao();
        mAllNotification=notficationDao.getAll();
    }

    LiveData<List<Notfication>> getAll() {
        return mAllNotification;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Notfication notfication) {
        NotificationDatabase.databaseWriteExecutor.execute(() -> {
            notficationDao.insertNotfictaion(notfication);
        });
    }
 }
