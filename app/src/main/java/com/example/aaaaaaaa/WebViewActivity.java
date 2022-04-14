package com.example.aaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private WebView webView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private String curUrl="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView=(WebView) findViewById(R.id.webView1);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        if(getIntent().hasExtra("URL"))
        {
            curUrl=getIntent().getStringExtra("URL");
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new MyWebViewClient());
            webView.loadUrl(getIntent().getStringExtra("URL"));
        }
    }
    @Override public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals(getIntent().getStringExtra("URL"))) {
                return false;
            }
            curUrl=String.valueOf(Uri.parse(url));
            webView.loadUrl(String.valueOf(Uri.parse(url)));

            return true;
        }
    }
    @Override
    public void onRefresh() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
                webView.clearHistory();
                if(getIntent().hasExtra("URL"))
                {
                    webView.clearFormData();
                    webView.loadUrl(getIntent().getStringExtra("URL"));
                }
            }
        }, 500);

    }
}