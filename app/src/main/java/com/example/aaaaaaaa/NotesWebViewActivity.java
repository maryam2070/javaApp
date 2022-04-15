package com.example.aaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NotesWebViewActivity extends AppCompatActivity {


    private WebView webView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private String curUrl="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_web_view);

        webView=(WebView) findViewById(R.id.webView1);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        webView.loadUrl("http://newportal.asu.edu.eg/science/ar/page/47/private-ads");

    }
    @Override public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    // Uniform Resource Identifie
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
}