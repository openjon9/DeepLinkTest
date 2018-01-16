package com.shoelives.deeplinktest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        settingWeb();
        getIntentAction();

    }

    private void getIntentAction() {
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri deeplink = intent.getData();

        if (deeplink != null) {
            textview.setText(deeplink + "");
        }


    }

    private void settingWeb() {
        WebSettings setting = webView.getSettings();
        setting.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new MyJavaScriptInterface(this), "LeonChen");
    }

    private void findView() {
        webView = (WebView) findViewById(R.id.webView);
        textview = (TextView) findViewById(R.id.textview);
    }

    public void test(View view) {
        webView.loadUrl("file:///android_asset/JavaScriptCallAndroid.html");
    }
}
