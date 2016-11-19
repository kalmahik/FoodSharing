package ru.hackrussia.foodsharing1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CategoryListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryListAdapter adapter;
    private List<Category> category;
    private FloatingActionButton fab;
    private Category ad;

    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            Intent intent = new Intent(CategoryListActivity.this, CategoryListActivity.class);
            intent.putExtra("title", category.get(position).getTitle());
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

        adapter = new CategoryListAdapter(category, clickListener);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryListActivity.this, AdListActivity.class);
                startActivity(intent);
            }
        });

    }

    public void createFakeUsers() {
        category = new ArrayList<>();

        String[] category = new String[]{"Хлебобулочные изделия", "Кондитерские изделия", "Напитки",
                "Замороженные продукты", "Фрукты и овощи", "Бакалея", "Молочные продукты", "Консервы", "Соусы",
                "Полуфабрикаты", "Чай и кофе", "Прочее"};

        for (int i = 0; i < category.length; i++) {
            this.category.add(new Category(category[i], "image"));
        }
    }



    public void onListChanged(int position) {
        adapter.notifyDataSetChanged();
    }
}
