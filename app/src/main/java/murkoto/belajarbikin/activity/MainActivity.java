package murkoto.belajarbikin.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import murkoto.belajarbikin.R;
import murkoto.belajarbikin.adapter.ArticleAdapter;
import murkoto.belajarbikin.model.Article;
import murkoto.belajarbikin.model.Articles;
import murkoto.belajarbikin.rest.ApiClient;
import murkoto.belajarbikin.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "b44a69512c4249b591bf886f5f1973d3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_articles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        final Context context = this;

        Call<Articles> call = apiService.getTopArticles("ign", "top", API_KEY);

        call.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {
                findViewById(R.id.progressBar).setVisibility(View.GONE);
                findViewById(R.id.recycler_view_articles).setVisibility(View.VISIBLE);
                List<Article> articles = response.body().getArticles();
                recyclerView.setAdapter(new ArticleAdapter(articles, context, new ArticleAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Article article) {
                        Intent intent = new Intent(MainActivity.this, NewsPageActivity.class);
                        intent.putExtra("URL", article.getUrl());
                        startActivity(intent);
                    }
                }));
            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {
            }
        });
    
    }
}
