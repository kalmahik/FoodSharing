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
    private List<Category> categories;
    private FloatingActionButton fab;
    private List<Ad> ads;


    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            Intent intent = new Intent(CategoryListActivity.this, AdListActivity.class);
            intent.putExtra("id", categories.get(position).getId());
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
        getSupportActionBar().setTitle("Выберите категорию");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = (FloatingActionButton) findViewById(R.id.fab);

        createCategoriesList();

        adapter = new CategoryListAdapter(categories, clickListener);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(v -> {
            //Intent intent = new Intent(CategoryListActivity.this, CategoryListActivity.class);
            //startActivity(intent);
        });
    }

    public void createCategoriesList() {
        categories = new ArrayList<>();

        categories.add(new Category("96", "Хлебобулочные изделия", "bread"));
        categories.add(new Category("97", "Кондитерские изделия", "candy"));
        categories.add(new Category("98", "Молочные продукты", "milk"));
        categories.add(new Category("99", "Напитки", "drinks"));
        categories.add(new Category("100", "Замороженные продукты", "frozen"));
        categories.add(new Category("101", "Фрукты и овощи", "fruits"));
        categories.add(new Category("102", "Бакалея", "grocery"));
        categories.add(new Category("103", "Соусы", "sauce"));
        categories.add(new Category("104", "Прочее", "something"));
        categories.add(new Category("105", "Чай и кофе", "tea"));
        categories.add(new Category("106", "Консервы", "tins"));

    }

}
