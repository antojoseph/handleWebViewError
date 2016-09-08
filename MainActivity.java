package com.jni.anto.catchemall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.widget.Button;
import android.widget.Toast;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends AppCompatActivity {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"Yoo",Toast.LENGTH_LONG).show();
                webView = (WebView) findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://www.nokia.com/en_in");
                webView.setWebViewClient(new WebViewClient(){

                    public void onReceivedError(WebView view , WebResourceRequest request, WebResourceError error){
                        //Toast.makeText(getApplicationContext(),"SomeError ",Toast.LENGTH_LONG).show();
                        String summary = "<html><body>No Internet .. no Love !</body></html>";
                        webView.loadData(summary, "text/html", null);
                    }
                });
            }
        });
    }
}
