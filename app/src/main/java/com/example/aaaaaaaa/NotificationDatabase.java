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

@Database(entities = {Notfication.class},version = 1, exportSchema = false)
public abstract class NotificationDatabase extends RoomDatabase {
    public abstract NotficationDao notficationDao();

    private static volatile NotificationDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static NotificationDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NotificationDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NotificationDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                NotficationDao dao = INSTANCE.notficationDao();
                dao.deleteAll();

                Notfication notfication = new Notfication();
                notfication.setId(1);
                notfication.setText("aaaaaa");
                notfication.setTitle("aaaaaaaaa");
                dao.insertNotfictaion(notfication);
                notfication = new Notfication();
                notfication.setId(2);
                notfication.setText("aaaaaa");
                notfication.setTitle("aaaaaaaaa");
                dao.insertNotfictaion(notfication);
            });
        }
    };
}
