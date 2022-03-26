package com.example.aaaaaaaa;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Notfication.class},version = 1)
public abstract class NotificationDatabase extends RoomDatabase {
    public abstract NotficationDao notficationDao();
    private static NotificationDatabase instance;

    public static synchronized NotificationDatabase getInstance(Context context)
    {
        if(instance==null)
        {
            instance=Room.databaseBuilder(context.getApplicationContext(),
                    NotificationDatabase.class,"notificaion_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsynckTask(instance).execute();
        }
    };
    private static class PopulateDbAsynckTask extends AsyncTask<Void,Void,Void> {
        private NotficationDao dao;

        public PopulateDbAsynckTask(NotificationDatabase db) {
            dao= db.notficationDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.insertNotfictaion(new Notfication(UUID.randomUUID(),"title","text","12:12"));
            return null;
        }
    }

}
