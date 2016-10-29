package com.example.nikolay.navi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebBetonActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_beton);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar my_toolbar4 = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(my_toolbar4);

        getSupportActionBar().setTitle(R.string.web_beton);

        my_toolbar4.setNavigationIcon(R.mipmap.ic_12);

        my_toolbar4.setNavigationOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent (WebBetonActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mWebView = (WebView) findViewById(R.id.webView);
        // включаем поддержку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки

        mWebView.setWebViewClient(new MyWebViewClient());

        String a = "https://www.google.com.ua/maps/search/бетон";
        mWebView.loadUrl (a + " ");

    }
    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        // do something on back.

        Intent a = new Intent(this,MainActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }

}
