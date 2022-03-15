package com.example.aaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private WebView webView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView=(WebView) findViewById(R.id.webView1);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        if(getIntent().hasExtra("URL"))
        {
            webView.loadUrl(getIntent().getStringExtra("URL"));
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
                    webView.loadUrl(getIntent().getStringExtra("URL"));
                }
            }
        }, 2000);

    }
}