package ru.hackrussia.foodsharing1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CategoryListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryListAdapter adapter;
    private List<Category> categories;
    private FloatingActionButton fab;
    private List<Ad> ads;
    private Ad[] ada;


    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            doSignUp();
            Intent intent = new Intent(CategoryListActivity.this, CategoryListActivity.class);
            intent.putExtra("title", categories.get(position).getTitle());
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ad);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        getSupportActionBar().setTitle("Категории");
        createFakeUsers();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = (FloatingActionButton) findViewById(R.id.fab);

        adapter = new CategoryListAdapter(categories, clickListener);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryListActivity.this, CategoryListActivity.class);
                startActivity(intent);
            }
        });

    }

    public void createFakeUsers() {
        categories = new ArrayList<>();

        String[] category = new String[]{"Хлебобулочные изделия", "Кондитерские изделия", "Напитки",
                "Замороженные продукты", "Фрукты и овощи", "Бакалея", "Молочные продукты", "Консервы", "Соусы",
                "Полуфабрикаты", "Чай и кофе", "Прочее"};

        for (int i = 0; i < category.length; i++) {
            this.categories.add(new Category(category[i], "image"));
        }
    }

    public void onListChanged(int position) {
        adapter.notifyDataSetChanged();
    }


    private void doSignUp() {
        //AuthPayload payload = new AuthPayload(username.getText().toString(), HashUtil.hash(password.getText().toString()));
        //final RequestContainer<AuthPayload> requestContainer = new RequestContainer<>(payload);
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                //RequestBody body = RequestBody
                 //       .create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(requestContainer));
                Request request = new Request.Builder()
                        .url("http://www.0a.by/json.php?cat=96")
                        //.post(body)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    Gson gson = new Gson();
                    //ada = gson.fromJson(response.body().string(), Ad[].class);
                    //AuthResponse ar = gson.fromJson(rc.getPayload().toString(), AuthResponse.class);
                    //Log.d(LoginActivity.class.getSimpleName(), ar.getUser().getName());
                    //Log.d(CategoryListActivity.class.getSimpleName(), ada[0].toString());

                    Log.d(CategoryListActivity.class.getSimpleName(), response.body().string());

                } catch (IOException e) {
                    Log.e(CategoryListActivity.class.getSimpleName(), Log.getStackTraceString(e));
                }
            }
        }).start();
    }
}
