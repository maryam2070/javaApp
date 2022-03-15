package com.example.aaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private CardView btn1;
    private CardView btn2;
    private CardView btn3;
    private CardView btn4;
    private CardView btn5;
    private CardView btn6;

    @Override
    protected void onStop () {
        super .onStop() ;
        startService( new Intent( this, NotificationService. class )) ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startService( new Intent( this, NotificationService. class )) ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService( new Intent( this, NotificationService. class )) ;
    }

    public void closeApp (View view) {
        finish() ;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService( new Intent( this, NotificationService. class )) ;

        variablesCreation();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    private void variablesCreation() {
        btn1=(CardView)findViewById(R.id.btn_1);
        btn2=(CardView)findViewById(R.id.btn_2);
        btn3=(CardView)findViewById(R.id.btn_3);
        btn4=(CardView)findViewById(R.id.btn_4);
        btn5=(CardView)findViewById(R.id.btn_5);
        btn6=(CardView)findViewById(R.id.btn_6);

    }


    @Override
    public void onClick(View view) {
        if(view==btn1)
        {
            Intent intent=new Intent(this,WebViewActivity.class);
            intent.putExtra("URL","https://asu2learn.asu.edu.eg/science/?redirect=0");
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
            intent.putExtra("URL","https://asu2learn.asu.edu.eg/science/?redirect=0");
            startActivity(intent);
        }if(view==btn5)
        {
            Intent intent=new Intent(this,WebViewActivity.class);
            intent.putExtra("URL","https://asu2learn.asu.edu.eg/science/?redirect=0");
            startActivity(intent);
        }
        if(view==btn6)
        {
            Intent intent=new Intent(this,WebViewActivity.class);
            intent.putExtra("URL","https://asu2learn.asu.edu.eg/science/?redirect=0");
            startActivity(intent);
        }

    }
}