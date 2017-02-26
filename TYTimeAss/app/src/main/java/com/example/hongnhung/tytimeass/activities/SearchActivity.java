package com.example.hongnhung.tytimeass.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hongnhung.tytimeass.R;
import com.example.hongnhung.tytimeass.adapter.ArticleAdapter;
import com.example.hongnhung.tytimeass.adapter.ChoiceArticle;
import com.example.hongnhung.tytimeass.models.Article;
import com.example.hongnhung.tytimeass.models.ArticleNow;
import com.example.hongnhung.tytimeass.models.ResonseClient;
import com.example.hongnhung.tytimeass.models.SearchRequest;
import com.example.hongnhung.tytimeass.net.ArticleApi;
import com.example.hongnhung.tytimeass.net.RetrofitArticle;
import com.example.hongnhung.tytimeass.utils.Contants;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    int countseach = 0;

    @Bind(R.id.btnSearch)
    Button mBtnSearch;

    @Bind(R.id.editText)
    EditText mEdtSearch;

    @Bind(R.id.rvArticle)
    RecyclerView mRvArticle;

    @Bind(R.id.pbLoad)
    ProgressBar pbLoad;

    @Bind(R.id.pbLoadMore)
    ProgressBar pbLoadMore;

    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;
    StaggeredGridLayoutManager gridLayoutManager;


    ArticleApi articleApi;

    private SearchRequest mSearchRequest = new SearchRequest();


    private interface Listener {
        void onResult(ResonseClient resonseClient);
    }

    public ArticleAdapter articleAdapter;
    public List<Article> mListArticles = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setUpApi();
        setUpVieW();
        search();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_settings);
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                mListArticles.clear();
                mSearchRequest.resetpage();
                search();
                return true;
            }
        });

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mListArticles.clear();
                mSearchRequest.setQuery(query);
                search();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.e("setting", "icon");
            return true;
        } else if (id == R.id.item_dialog) {
            Log.e("dialog", "chow");
            FragmentManager fm = getSupportFragmentManager();
            DialogChoiceFragment dialogChoiceFragment = new DialogChoiceFragment();

            dialogChoiceFragment.show(fm, "sample fragment");


        }

        return super.onOptionsItemSelected(item);
    }

    private void handComplete() {
        pbLoad.setVisibility(View.GONE);
        pbLoadMore.setVisibility(View.GONE);
    }

    private void setUpVieW() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRvArticle.setHasFixedSize(true);
        mRvArticle.setLayoutManager(gridLayoutManager);
        articleAdapter = new ArticleAdapter(SearchActivity.this, mListArticles);
        articleAdapter.setChoiceArticle(new ChoiceArticle() {
            @Override
            public void Choice(Article article) {
                String json = new Gson().toJson(article);
                Log.e("jsonar", json);
                Intent intent = new Intent(SearchActivity.this, ArticleActivity.class);
                intent.putExtra(Contants.KEY_ARTICLE, article);
                startActivity(intent);
            }

            @Override
            public void onLoadMore() {
                mSearchRequest.nextPage();
                search();
            }
        });
        mRvArticle.setAdapter(articleAdapter);
    }

    private void setUpApi() {
        mSearchRequest = new SearchRequest();
        articleApi = RetrofitArticle.get().create(ArticleApi.class);

    }

    public void search() {
        pbLoad.setVisibility(View.VISIBLE);
        articleApi.getArticle(mSearchRequest.toQueryMap()).enqueue(new Callback<ResonseClient>() {
            @Override
            public void onResponse(Call<ResonseClient> call, Response<ResonseClient> response) {

                mListArticles.addAll(response.body().getArticleNow().getArticleList());
                Log.e("size", mListArticles.size() + "");
                articleAdapter.notifyDataSetChanged();
                handComplete();

            }

            @Override
            public void onFailure(Call<ResonseClient> call, Throwable t) {
                Log.d("Error", t.getMessage());
                handComplete();
            }
        });


    }

}
