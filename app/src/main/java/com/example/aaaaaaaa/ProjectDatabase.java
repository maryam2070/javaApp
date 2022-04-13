package com.example.aaaaaaaa;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Notfication.class,Course.class},version = 2, exportSchema = false)
public abstract class ProjectDatabase extends RoomDatabase {
    public abstract ProjectDao Dao();

    private static volatile ProjectDatabase instance;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static ProjectDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (ProjectDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            ProjectDatabase.class, "notification_database")
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
                ProjectDao dao = instance.Dao();
                dao.deleteAll();
                dao.insertNotfictaion(new Notfication(UUID.randomUUID(),"title","text","12:12"));
            });
        }
    };



}
