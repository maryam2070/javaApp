package com.example.aaaaaaaa;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private CardView btn1;
    private CardView btn2;
    private CardView btn3;
    private CardView btn4;
    private CardView btn5;
    private CardView btn6;
    private CardView btn7;
    private TextView curTime;
    private ImageButton notificationBtn;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onDestroy() {
        super.onDestroy();
    //    startForegroundService(new Intent( this, NotificationService. class ));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent( this, NotificationService. class ));

        variablesCreation();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        curTime.setText(dtf.format(now));

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        notificationBtn.setOnClickListener(this);
    }

    private void variablesCreation() {
        notificationBtn=(ImageButton)findViewById(R.id.notification_btn);
        btn1=(CardView)findViewById(R.id.btn_1);
        btn2=(CardView)findViewById(R.id.btn_2);
        btn3=(CardView)findViewById(R.id.btn_3);
        btn4=(CardView)findViewById(R.id.btn_4);
        btn5=(CardView)findViewById(R.id.btn_5);
        btn6=(CardView)findViewById(R.id.btn_6);
        btn7=(CardView)findViewById(R.id.btn_7);
        curTime=(TextView)findViewById(R.id.cue_time_tv);

    }


    @Override
    public void onClick(View view) {
        if(view==notificationBtn)
        {
            Intent intent=new Intent(this,NotificationActivity.class);
            startActivity(intent);
        }
        if(view==btn1)
        {
            //notes
            Intent intent=new Intent(this,WebViewActivity.class);
            intent.putExtra("URL","https://science.asu.edu.eg/ar/events");
            startActivity(intent);
        }
        if(view==btn2)
        {
            Intent intent=new Intent(this,WebViewActivity.class);
            intent.putExtra("URL","https://asu2learn.asu.edu.eg/science/?redirect=0");
            startActivity(intent);
        }
        if(view==btn3)
        {
            startActivity(new Intent(this,GpaCalculator.class));
        }

        if(view==btn4)
        {
            Intent intent=new Intent(this,WebViewActivity.class);
            intent.putExtra("URL","https://science.asu.edu.eg/ar/news");
            startActivity(intent);
        }if(view==btn5)
        {
            Intent intent=new Intent(this,WebViewActivity.class);
            intent.putExtra("URL","https://science.asu.edu.eg/ar/announcements");
            startActivity(intent);
        }
        if(view==btn6)
        {
            //facebook
            Intent intent=new Intent(this,WebViewActivity.class);
            intent.putExtra("URL","https://asu2learn.asu.edu.eg/science/?redirect=0");
            startActivity(intent);
        }
        if(view==btn7)
        {
            //facebook
            Intent intent=new Intent(this,WebViewActivity.class);
            intent.putExtra("URL","https://asu2learn.asu.edu.eg/science/?redirect=0");
            startActivity(intent);
        }

    }

}