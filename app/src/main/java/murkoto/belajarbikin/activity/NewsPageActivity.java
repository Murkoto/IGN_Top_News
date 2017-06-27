package murkoto.belajarbikin.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import murkoto.belajarbikin.R;

public class NewsPageActivity extends AppCompatActivity {

    private WebView wv;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_page);

        wv = (WebView) findViewById(R.id.content);
        wv.setWebViewClient(new WebViewClient());
        Intent intent = getIntent();
        url = intent.getStringExtra("URL");
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
        wv.setHorizontalScrollBarEnabled(false);
    }
}
