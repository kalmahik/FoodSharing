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
import java.util.UUID;

public class AdListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdListAdapter adapter;
    private List<Ad> ads;
    private FloatingActionButton fab;
    private AdDatabase adDB;
    private Ad ad;

    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            Intent intent = new Intent(AdListActivity.this, AdListActivity.class);
            intent.putExtra("title", ads.get(position).getTitle());
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ad);
        adDB = new AdDatabase();
        ads = adDB.getAll();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        createFakeUsers();
        performUsers();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = (FloatingActionButton) findViewById(R.id.fab);

        adapter = new AdListAdapter(ads, clickListener);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdListActivity.this, AdListActivity.class);
                startActivity(intent);
            }
        });

    }

    public void createFakeUsers() {
        ads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //adDB.clean();
            ad = new Ad(UUID.randomUUID().toString(), "Печеньки", "Шоколадные печеньки", 2016-i);
            ads.add(ad);
            adDB.copyOrUpdate(ad);
        }
    }

    private void performUsers() {
        ads = adDB.getAll();
        adDB.addChangeListener(element -> {
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void onListChanged(int position) {
        adapter.notifyDataSetChanged();
    }
}
