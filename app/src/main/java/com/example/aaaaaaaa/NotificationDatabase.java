package com.example.aaaaaaaa;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Notfication.class},version = 1, exportSchema = false)
public abstract class NotificationDatabase extends RoomDatabase {
    public abstract NotficationDao notficationDao();

    private static volatile NotificationDatabase instance;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static NotificationDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (NotificationDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            NotificationDatabase.class, "notification_database")
                            .addCallback(roomCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                NotficationDao dao = instance.notficationDao();
                dao.deleteAll();
                dao.insertNotfictaion(new Notfication(UUID.randomUUID(),"title","text","12:12"));
            });
        }
    };



}
