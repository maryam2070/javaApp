package com.example.aaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private LinearLayout container;

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
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                setVisibility();
                webView.loadUrl(
                        "https://material.io/resources/color/#!/?view.left=0&view.right=1&primary.color=9dffab&secondary.color=C8E6C9");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                setVisibility();
                webView.loadUrl(
                        "https://material.io/resources/color/#!/?view.left=0&view.right=1&primary.color=9dffab&secondary.color=C8E6C9");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                setVisibility();
                webView.loadUrl(
                        "https://material.io/resources/color/#!/?view.left=0&view.right=1&primary.color=9dffab&secondary.color=C8E6C9");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                setVisibility();
                webView.loadUrl(
                        "https://material.io/resources/color/#!/?view.left=0&view.right=1&primary.color=9dffab&secondary.color=C8E6C9");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                setVisibility();

                webView.loadUrl(
                        "https://material.io/resources/color/#!/?view.left=0&view.right=1&primary.color=9dffab&secondary.color=C8E6C9");
            }
        });

///////


       /* Button loadBtn = (Button) this.findViewById(R.id.btn_load);
        loadBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Load();
            }
        });*/
    }
    private void setVisibility()
    {
        container.setVisibility(View.GONE);
        webView.setVisibility(View.VISIBLE);
    }
    private void variablesCreation() {
            webView = (WebView) findViewById(R.id.webView1);

        btn1=(Button)findViewById(R.id.btn_1);
        btn2=(Button)findViewById(R.id.btn_2);
        btn3=(Button)findViewById(R.id.btn_3);
        btn4=(Button)findViewById(R.id.btn_4);
        btn5=(Button)findViewById(R.id.btn_5);
        btn6=(Button)findViewById(R.id.btn_6);
        container=(LinearLayout)findViewById(R.id.calc_container);

        container.setVisibility(View.GONE);
        webView.getSettings().setJavaScriptEnabled(true);
    }





}