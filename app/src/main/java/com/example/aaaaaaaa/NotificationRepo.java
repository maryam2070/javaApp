package com.example.aaaaaaaa;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;
import java.util.UUID;

public class NotificationRepo {
    private NotficationDao notficationDao;
    private LiveData<List<Notfication>>notifications;

    public NotificationRepo(Application application){
        NotificationDatabase database=NotificationDatabase.getInstance(application);
        notficationDao= database.notficationDao();
        notifications=notficationDao.getAll();
    }
    public void insert(Notfication notfication){
        new InsertNotificationAsynckTask(notficationDao).execute(notfication);
    }
    public void deleteAll(){
        new DeleteAllNotificationAsynckTask(notficationDao).execute();
    }
    public LiveData<List<Notfication>>getAllNotifications()
    {
        return notifications;
    }
    private static class InsertNotificationAsynckTask extends AsyncTask<Notfication,Void,Void>{
        private NotficationDao dao;

        private InsertNotificationAsynckTask(NotficationDao notficationDao)
        {
            dao=notficationDao;
        }

        @Override
        protected Void doInBackground(Notfication... notfications) {
            dao.insertNotfictaion(notfications[0]);
            return null;
        }
    }

    private static class DeleteAllNotificationAsynckTask extends AsyncTask<Void,Void,Void>{
        private NotficationDao dao;

        private DeleteAllNotificationAsynckTask(NotficationDao notficationDao)
        {
            dao=notficationDao;
        }

        @Override
        protected Void doInBackground(Void... Void) {
            dao.deleteAll();
            return null;
        }
    }


}
