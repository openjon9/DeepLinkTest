package com.shoelives.deeplinktest;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Rey on 2018/1/16.
 */

public class MyJavaScriptInterface {
    private Context context;

    public MyJavaScriptInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void sayHello(String name){
        Toast.makeText(context, "This Message is From Android App, Hi," + name, Toast.LENGTH_LONG).show();
    }
}
