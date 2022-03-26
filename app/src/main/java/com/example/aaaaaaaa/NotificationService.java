package com.example.aaaaaaaa;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

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

    public StringBuilder oldString1 ;
    public StringBuilder newString1 ;
    public StringBuilder oldString2 ;
    public StringBuilder newString2 ;
    public StringBuilder oldString3 ;
    public StringBuilder newString3 ;
    public StringBuilder oldString4 ;
    public StringBuilder newString4 ;
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
        Log. e ( TAG , "onStartCommand" ) ;
        super .onStartCommand(intent , flags , startId) ;
        startTimer() ;
        return START_STICKY ;
    }
    @Override
    public void onCreate () {
        Log. e ( TAG , "onCreate" ) ;
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
        MyTask taskLoad1 = new MyTask();
        if(c==1)
        {
            //////////events
            taskLoad1.execute("https://sciasuedu-my.sharepoint.com/personal/hmbahig_sci_asu_edu_eg/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fhmbahig%5Fsci%5Fasu%5Fedu%5Feg%2FDocuments%2FCrypto%2D%20COMP%20308%20%2D%20Summer");
        }
        else if(c==2){
            //////////notes
            taskLoad1.execute("https://sciasuedu-my.sharepoint.com/personal/hmbahig_sci_asu_edu_eg/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fhmbahig%5Fsci%5Fasu%5Fedu%5Feg%2FDocuments%2FCrypto%2D%20COMP%20308%20%2D%20Summer");
        }else if(c==3){
            //////////annou
            taskLoad1.execute("https://sciasuedu-my.sharepoint.com/personal/hmbahig_sci_asu_edu_eg/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fhmbahig%5Fsci%5Fasu%5Fedu%5Feg%2FDocuments%2FCrypto%2D%20COMP%20308%20%2D%20Summer");
        }else if(c==4){
            /////////news
            taskLoad1.execute("https://www.c-sharpcorner.com/blogs/everything-you-need-to-know-about-contextrelated-memory-leaks-in-android#:~:text=Context-related%20memory%20leaks%20in%20Android%20These%20Contexts%20are,to%20access%20the%20app%E2%80%99s%20resources%20and%20environment%20data.");
        }
    }


    private class MyTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String ... urls) {
            if(c==1)
            {
                c++;
                try {

                    if (oldString1 == null) {
                        URL url = new URL(urls[0]);
                        URLConnection uc = url.openConnection();
                        oldString1 = new StringBuilder();
                        uc.setDoInput(true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null)
                            oldString1.append(inputLine);
                        in.close();
                        return oldString1.toString();
                    }
                    else {
                        URL url = new URL(urls[0]);
                        URLConnection uc = url.openConnection();
                        newString1 = new StringBuilder();
                        uc.setDoInput(true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null)
                            newString1.append(inputLine);
                        in.close();
                        newString1.trimToSize();
                        oldString1.trimToSize();

                        System.out.println("oldddd" + oldString1);
                        System.out.println("                        ");
                        System.out.println("new  " + newString1);
                        int c = 0;
                        for (int i = 0; i < Math.min(newString1.length(), oldString1.length()); i++) {

                            if (newString1.charAt(i) != oldString1.charAt(i)) {
                                // System.out.println(i);
                                c++;
                                //   break;
                            }
                        }
                        System.out.println("11111111111111  " + c);
                        if (!(newString1.toString().equals(oldString1.toString())) && newString1.charAt(0) == '<' && oldString1.charAt(0) == '<') {
                            createNotification("Faculty of science","We have new event");
                            oldString1 = new StringBuilder();
                            oldString1.append(newString1);
                        }

                        return newString1.toString();
                    }


                }catch (Exception e)
                {
                    return e.getMessage();
                }
            }
            else if(c==2)
            {
                c++;
                try {

                    if (oldString2 == null) {
                        URL url = new URL(urls[0]);
                        URLConnection uc = url.openConnection();
                        oldString2 = new StringBuilder();
                        uc.setDoInput(true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null)
                            oldString2.append(inputLine);
                        in.close();
                        return oldString2.toString();
                    }
                    else {
                        URL url = new URL(urls[0]);
                        URLConnection uc = url.openConnection();
                        newString2 = new StringBuilder();
                        uc.setDoInput(true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null)
                            newString2.append(inputLine);
                        in.close();
                        newString2.trimToSize();
                        oldString2.trimToSize();

                        System.out.println("oldddd" + oldString2);
                        System.out.println("                        ");
                        System.out.println("new  " + newString2);
                        int c = 0;
                        for (int i = 0; i < Math.min(newString2.length(), oldString2.length()); i++) {

                            if (newString2.charAt(i) != oldString2.charAt(i)) {
                                // System.out.println(i);
                                c++;
                                //   break;
                            }
                        }
                        System.out.println("2222222222222222222 " + c);
                        if (!(newString2.toString().equals(oldString2.toString())) && newString2.charAt(0) == '<' && oldString2.charAt(0) == '<') {
                            createNotification("Faculty of science","We have new note");
                            oldString2 = new StringBuilder();
                            oldString2.append(newString2);
                        }

                        return newString2.toString();
                    }


                }catch (Exception e)
                {
                    return e.getMessage();
                }
            }
            else if(c==3)
            {
                c++;
                try {

                    if (oldString3 == null) {
                        URL url = new URL(urls[0]);
                        URLConnection uc = url.openConnection();
                        oldString3 = new StringBuilder();
                        uc.setDoInput(true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null)
                            oldString3.append(inputLine);
                        in.close();
                        return oldString3.toString();
                    }
                    else {
                        URL url = new URL(urls[0]);
                        URLConnection uc = url.openConnection();
                        newString3 = new StringBuilder();
                        uc.setDoInput(true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null)
                            newString3.append(inputLine);
                        in.close();
                        newString3.trimToSize();
                        oldString3.trimToSize();

                        System.out.println("oldddd" + oldString3);
                        System.out.println("                        ");
                        System.out.println("new  " + newString3);
                        int c = 0;
                        for (int i = 0; i < Math.min(newString3.length(), oldString3.length()); i++) {

                            if (newString3.charAt(i) != oldString3.charAt(i)) {
                                // System.out.println(i);
                                c++;
                                //   break;
                            }
                        }
                        System.out.println("3333333333333" + c);
                        if (!(newString3.toString().equals(oldString3.toString())) && newString3.charAt(0) == '<' && oldString3.charAt(0) == '<') {
                            createNotification("Faculty of science","We have new announcement");
                            oldString3 = new StringBuilder();
                            oldString3.append(newString3);
                        }

                        return newString3.toString();
                    }


                }catch (Exception e)
                {
                    return e.getMessage();
                }
            }

            else
            {
                c=1;
                try {

                    if (oldString4 == null) {
                        URL url = new URL(urls[0]);
                        URLConnection uc = url.openConnection();
                        oldString4 = new StringBuilder();
                        uc.setDoInput(true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null)
                            oldString4.append(inputLine);
                        in.close();
                        return oldString4.toString();
                    }
                    else {
                        URL url = new URL(urls[0]);
                        URLConnection uc = url.openConnection();
                        newString4 = new StringBuilder();
                        uc.setDoInput(true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null)
                            newString4.append(inputLine);
                        in.close();
                        newString4.trimToSize();
                        oldString4.trimToSize();

                        System.out.println("oldddd" + oldString4);
                        System.out.println("                        ");
                        System.out.println("new  " + newString4);
                        int c = 0;
                        for (int i = 0; i < Math.min(newString4.length(), oldString4.length()); i++) {

                            if (newString4.charAt(i) != oldString4.charAt(i)) {
                                // System.out.println(i);
                                c++;
                                //   break;
                            }
                        }
                        System.out.println("444444444444" + c);
                        if (!(newString4.toString().equals(oldString4.toString())) && newString4.charAt(0) == '<' && oldString4.charAt(0) == '<') {
                            createNotification("Faculty of science","We have new news");
                            oldString4 = new StringBuilder();
                            oldString4.append(newString4);
                        }
                        return newString4.toString();
                    }

                }catch (Exception e)
                {
                    return e.getMessage();
                }
            }
        }



    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotification (String title, String text) {


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Notfication notfication=new Notfication(UUID.randomUUID(),title,text,dtf.format(now));
        NotificationRepo repo=new NotificationRepo(getApplication());
        repo.insert(notfication);
        System.out.println("notfffffffffffffffffff");

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