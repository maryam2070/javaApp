package com.example.aaaaaaaa;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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
    @RequiresApi(api = Build.VERSION_CODES.O)
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
////////////////***********     links to test notifications ********//////////
        task1.execute("https://developer.android.com/training/notify-user/navigation#java");
        task2.execute("https://developer.android.com/training/notify-user/navigation#java");
        task3.execute("https://developer.android.com/training/notify-user/navigation#java");
        task4.execute("https://developer.android.com/training/notify-user/navigation#java");
////////////////////**************** actual links  ***********//////

       /* task1.execute("https://science.asu.edu.eg/ar/events");
        task2.execute("https://science.asu.edu.eg/ar/announcements");
        task3.execute("http://newportal.asu.edu.eg/science/ar/page/47/private-ads");
        task4.execute("https://science.asu.edu.eg/ar/news");*/

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
                    System.out.println("ccccccccccc"+s);
                    System.out.println("ccccccccccc"+olds);

                    if (!(s.toString().equals(olds.toString()))  ) {
                        if(s.charAt(0) == '<' && olds.charAt(0) == '<')
                            createNotification("Faculty of science", "We have new event","events");
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
                if (sp.getString("firstTime2", "") == "") {
                    myEdit.putString("firstTime2", "done");
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
                    myEdit.putString("s2", s1.toString());
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
                    String olds = sp.getString("s2", "");
                    System.out.println("ccccccccccc1111111 "+s);
                    System.out.println("ccccccccccc111111111 "+olds);

                    if (!(s.toString().equals(olds.toString()))  ) {
                        if(s.charAt(0) == '<' && olds.charAt(0) == '<')
                              createNotification("Faculty of science","We have new note","note");
                        myEdit.putString("s2", s.toString());
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
                if (sp.getString("firstTime3", "") == "") {
                    myEdit.putString("firstTime3", "done");
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
                    myEdit.putString("s3", s1.toString());
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
                    String olds = sp.getString("s3", "");
                    System.out.println("ccccccccccc1111111 "+s);
                    System.out.println("ccccccccccc111111111 "+olds);

                    if (!(s.toString().equals(olds.toString()))  ) {
                        if(s.charAt(0) == '<' && olds.charAt(0) == '<')
                             createNotification("Faculty of science","We have new News","news");
                        myEdit.putString("s3", s.toString());
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
                if (sp.getString("firstTime4", "") == "") {
                    myEdit.putString("firstTime4", "done");
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
                    myEdit.putString("s4", s1.toString());
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
                    String olds = sp.getString("s4", "");
                    System.out.println("ccccccccccc1111111 " + s);
                    System.out.println("ccccccccccc111111111 " + olds);

                    if (!(s.toString().equals(olds.toString())) ) {
                        if( s.charAt(0) == '<' && olds.charAt(0) == '<')
                            createNotification("Faculty of science", "We have new announcement","announcements");
                        myEdit.putString("s4", s.toString());
                        myEdit.commit();
                    }

                    return s.toString();
                }

            } catch (Exception e) {
                return e.getMessage();
            }

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotification (String title, String text,String type) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Notfication notfication=new Notfication(UUID.randomUUID(),title,text,dtf.format(now));
        ProjectRepo repo=new ProjectRepo(getApplication());
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


        Intent intent = startActivityWebView(type);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(intent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        mBuilder.setContentIntent(resultPendingIntent);

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

    private Intent startActivityWebView(String type) {
        Intent intent;
        if(type.equals("announcements"))
        {
            intent=new Intent(this,AnnouncementWebViewActivity.class);

        }else if(type.equals("events")){
            intent=new Intent(this,EventsWebViewActivity.class);
        }else if(type.equals("news")){
            intent=new Intent(this,NewsWebViewActivity.class);
        }else {
         intent=new Intent(this,NotesWebViewActivity.class);
        }
        return intent;
    }

}