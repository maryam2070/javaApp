package com.example.aaaaaaaa;

import static java.sql.DriverManager.println;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;


public class NotificationService extends Service {

    public StringBuilder oldString ;
    public StringBuilder newString ;
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
    public void Load()
    {
        MyTask taskLoad = new MyTask();
        taskLoad.execute("https://asu2learn.asu.edu.eg/science/?redirect=0");
    }
    private class MyTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String ... urls) {
            try {
                if (oldString == null) {
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    oldString = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        oldString.append(inputLine);
                    in.close();
                    return oldString.toString();
                } else {
                    URL url = new URL(urls[0]);
                    URLConnection uc = url.openConnection();
                    newString = new StringBuilder();
                    uc.setDoInput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        newString.append(inputLine);
                    in.close();
                    newString.trimToSize();
                    oldString.trimToSize();

                    System.out.println("oldddd"+oldString);
                    System.out.println("                        ");
                    System.out.println("new  "+newString);
                    int c=0;
                    for(int i=0;i<Math.min(newString.length(),oldString.length());i++)
                    {

                        if(newString.charAt(i)!=oldString.charAt(i))
                        {
                            //System.out.println(i);
                            c++;
                           // break;
                        }
                    }
                    System.out.println("cc  "+c);
                    if(c>200&&newString.charAt(0)=='<'&&oldString.charAt(0)=='<')
                    {
                        createNotification();
                        oldString=new StringBuilder();
                        oldString.append(newString);
                    }

                    return newString.toString();
                }


            }catch (Exception e)
            {
                return e.getMessage();
            }
        }


        @Override
        protected void onPostExecute(String result)
        {
            System.out.println("aaaaaa"+result);
           // Toast.makeText(getApplication(), result, Toast.LENGTH_LONG).show();
        }
    }
    private void createNotification () {
     //   System.out.println("notfffffffffffffffffff");
        NotificationManager mNotificationManager = (NotificationManager) getSystemService( NOTIFICATION_SERVICE ) ;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext() , default_notification_channel_id ) ;
        mBuilder.setContentTitle( "ثبح ثباحو ثباحو ثبح" ) ;
        mBuilder.setContentText( "ايوة يا عمرووو ياحلاااااااااااااق ظبطلي الابلكيشن علشان مش مركز في اي حاجة" ) ;
        mBuilder.setTicker( "ءءءءءءءءءءء" ) ;
        mBuilder.setSmallIcon(R.drawable. ic_launcher_foreground ) ;
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