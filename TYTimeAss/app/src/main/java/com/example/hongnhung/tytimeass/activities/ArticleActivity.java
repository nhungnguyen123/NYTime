package com.example.hongnhung.tytimeass.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.hongnhung.tytimeass.R;
import com.example.hongnhung.tytimeass.models.Article;
import com.example.hongnhung.tytimeass.utils.Contants;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.hongnhung.tytimeass.R.id.toolbar;

public class ArticleActivity extends AppCompatActivity {


    @Bind(R.id.wvArticle)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);

        final Article article = (Article) getIntent().getParcelableExtra(Contants.KEY_ARTICLE);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(article.getWebUrl());
                return true;
            }
        });
        mWebView.loadUrl(article.getWebUrl());
        Log.e("urlWeb", article.getWebUrl() + "");

    }

}
