package com.example.aaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView=(WebView) findViewById(R.id.webView1);

        if(getIntent().hasExtra("URL"))
        {
            webView.loadUrl(getIntent().getStringExtra("URL"));
        }
    }
}