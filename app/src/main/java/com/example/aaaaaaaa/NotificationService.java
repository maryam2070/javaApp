package com.example.aaaaaaaa;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelProvider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;


public class NotificationService extends Service {

    SharedPreferences sp ;
    SharedPreferences.Editor myEdit;
    public int c=1;
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;
    Timer timer ;
    TimerTask timerTask ;
    String TAG = "Timers" ;
    int Your_X_SECS = 5 ;
    @Override
    public IBinder onBind (Intent arg0) {
        return null;
    }
    @Override
    public int onStartCommand (Intent intent , int flags , int startId) {
        super .onStartCommand(intent , flags , startId) ;
        startTimer() ;
        sp = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        myEdit = sp.edit();
        return START_STICKY ;
    }
    @Override
    public void onDestroy () {
        Log. e ( TAG , "onDestroy" ) ;
        stopTimerTask() ;
        super .onDestroy() ;
    }
    //we are going to use a handler to be able to run in our TimerTask
    final Handler handler = new Handler() ;
    public void startTimer () {
        timer = new Timer() ;
        initializeTimerTask() ;
        timer .schedule( timerTask , 5000 , Your_X_SECS * 1000 ) ; //
    }
    public void stopTimerTask () {
        if ( timer != null ) {
            timer .cancel() ;
            timer = null;
        }
    }
    public void initializeTimerTask () {
        timerTask = new TimerTask() {
            public void run () {
                handler .post( new Runnable() {
                    public void run () {

                        Load();

                    }
                }) ;
            }
        } ;
    }

    public void Load() {
        EventTask task1=new EventTask();
        AnnouncementTask task2 = new AnnouncementTask();
        NoteTask task3 = new NoteTask();
        NewsTask task4=new NewsTask();

        task1.execute("https://sciasuedu-my.sharepoint.com/personal/hmbahig_sci_asu_edu_eg/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fhmbahig%5Fsci%5Fasu%5Fedu%5Feg%2FDocuments%2FCrypto%2D%20COMP%20308%20%2D%20Summer");
        task2.execute("https://sciasuedu-my.sharepoint.com/personal/hmbahig_sci_asu_edu_eg/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fhmbahig%5Fsci%5Fasu%5Fedu%5Feg%2FDocuments%2FCrypto%2D%20COMP%20308%20%2D%20Summer");
        task3.execute("https://sciasuedu-my.sharepoint.com/personal/hmbahig_sci_asu_edu_eg/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fhmbahig%5Fsci%5Fasu%5Fedu%5Feg%2FDocuments%2FCrypto%2D%20COMP%20308%20%2D%20Summer");
        task4.execute("https://www.c-sharpcorner.com/blogs/everything-you-need-to-know-about-contextrelated-memory-leaks-in-android#:~:text=Context-related%20memory%20leaks%20in%20Android%20These%20Contexts%20are,to%20access%20the%20app%E2%80%99s%20resources%20and%20environment%20data.");

    }


    private class EventTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String ... urls) {

            try {
                if (sp.getString("firstTime1", "") == "") {
                    myEdit.putString("firstTime1", "done");
                    myEdit.commit();
                    StringBuilder s1;
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    s1 = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        s1.append(inputLine);
                    in.close();
                    s1.trimToSize();
                    myEdit.putString("s1", s1.toString());
                    myEdit.commit();
                    return s1.toString();
                } else {
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    StringBuilder s;
                    s = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        s.append(inputLine);
                    in.close();
                    s.trimToSize();
                    String olds = sp.getString("s1", "");
                    System.out.println("ccccccccccc1111111 "+s);
                    System.out.println("ccccccccccc111111111 "+olds);

                    if (!(s.toString().equals(olds.toString())) && s.charAt(0) == '<' && olds.charAt(0) == '<') {
                        createNotification("Faculty of science", "We have new event");
                        myEdit.putString("s1", s.toString());
                        myEdit.commit();
                    }

                    return s.toString();
                }

            } catch (Exception e) {
                return e.getMessage();
            }

        }

    }
    private class NoteTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String ... urls) {

            try {
                if (sp.getString("firstTime1", "") == "") {
                    myEdit.putString("firstTime1", "done");
                    myEdit.commit();
                    StringBuilder s1;
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    s1 = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        s1.append(inputLine);
                    in.close();
                    s1.trimToSize();
                    myEdit.putString("s1", s1.toString());
                    myEdit.commit();
                    return s1.toString();
                } else {
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    StringBuilder s;
                    s = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        s.append(inputLine);
                    in.close();
                    s.trimToSize();
                    String olds = sp.getString("s1", "");
                    System.out.println("ccccccccccc1111111 "+s);
                    System.out.println("ccccccccccc111111111 "+olds);

                    if (!(s.toString().equals(olds.toString())) && s.charAt(0) == '<' && olds.charAt(0) == '<') {
                        createNotification("Faculty of science","We have new note");
                        myEdit.putString("s1", s.toString());
                        myEdit.commit();
                    }
                    return s.toString();
                }

            } catch (Exception e) {
                return e.getMessage();
            }

        }

    }
    private class NewsTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String ... urls) {

            try {
                if (sp.getString("firstTime1", "") == "") {
                    myEdit.putString("firstTime1", "done");
                    myEdit.commit();
                    StringBuilder s1;
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    s1 = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        s1.append(inputLine);
                    in.close();
                    s1.trimToSize();
                    myEdit.putString("s1", s1.toString());
                    myEdit.commit();
                    return s1.toString();
                } else {
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    StringBuilder s;
                    s = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        s.append(inputLine);
                    in.close();
                    s.trimToSize();
                    String olds = sp.getString("s1", "");
                    System.out.println("ccccccccccc1111111 "+s);
                    System.out.println("ccccccccccc111111111 "+olds);

                    if (!(s.toString().equals(olds.toString())) && s.charAt(0) == '<' && olds.charAt(0) == '<') {
                        createNotification("Faculty of science","We have new News");
                        myEdit.putString("s1", s.toString());
                        myEdit.commit();
                    }

                    return s.toString();
                }

            } catch (Exception e) {
                return e.getMessage();
            }

        }

    }
    private class AnnouncementTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {


            // if(c==1) {
            c++;
            try {
                if (sp.getString("firstTime1", "") == "") {
                    myEdit.putString("firstTime1", "done");
                    myEdit.commit();
                    StringBuilder s1;
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    s1 = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        s1.append(inputLine);
                    in.close();
                    s1.trimToSize();
                    myEdit.putString("s1", s1.toString());
                    myEdit.commit();
                    return s1.toString();
                } else {
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    StringBuilder s;
                    s = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        s.append(inputLine);
                    in.close();
                    s.trimToSize();
                    String olds = sp.getString("s1", "");
                    System.out.println("ccccccccccc1111111 " + s);
                    System.out.println("ccccccccccc111111111 " + olds);

                    if (!(s.toString().equals(olds.toString())) && s.charAt(0) == '<' && olds.charAt(0) == '<') {
                        createNotification("Faculty of science", "We have new announcement");
                        myEdit.putString("s1", s.toString());
                        myEdit.commit();
                    }

                    return s.toString();
                }

            } catch (Exception e) {
                return e.getMessage();
            }

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        private void createNotification(String title, String text) {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            Notfication notfication = new Notfication(UUID.randomUUID(), title, text, dtf.format(now));
            NotificationRepo repo = new NotificationRepo(getApplication());
            repo.insert(notfication);

            NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), default_notification_channel_id);
            mBuilder.setContentTitle(title);
            mBuilder.setContentText(text);
            mBuilder.setTicker("Faculty of science ASU");
            mBuilder.setSmallIcon(R.drawable.logo2);
            mBuilder.setAutoCancel(true);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                assert mNotificationManager != null;
                mNotificationManager.createNotificationChannel(notificationChannel);
            }
            assert mNotificationManager != null;
            mNotificationManager.notify((int) System.currentTimeMillis(), mBuilder.build());


        }


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotification (String title, String text) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Notfication notfication=new Notfication(UUID.randomUUID(),title,text,dtf.format(now));
        NotificationRepo repo=new NotificationRepo(getApplication());
        repo.insert(notfication);
        NotificationAdapter adapter=adapter=new NotificationAdapter(getApplication());
        adapter.notifyDataSetChanged();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService( NOTIFICATION_SERVICE ) ;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext() , default_notification_channel_id ) ;
        mBuilder.setContentTitle( title) ;
        mBuilder.setContentText( text ) ;
        mBuilder.setTicker( "Faculty of science ASU" ) ;
        mBuilder.setSmallIcon(R.drawable.logo2) ;
        mBuilder.setAutoCancel( true ) ;
        if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
            int importance = NotificationManager. IMPORTANCE_HIGH ;
            NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
            mBuilder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(notificationChannel) ;
        }
        assert mNotificationManager != null;
        mNotificationManager.notify(( int ) System. currentTimeMillis () , mBuilder.build()) ;



    }

}