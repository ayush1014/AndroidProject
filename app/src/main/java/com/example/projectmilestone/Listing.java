package com.example.projectmilestone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Listing extends AppCompatActivity {
    Button new_order;
    DBHelper dbHelper;
    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<order_details> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        init();
        loadData();

        Intent i = new Intent(this,MainActivity.class);
        new_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.listView);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        recyclerView.addItemDecoration(itemDecorator);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        new_order = findViewById(R.id.new_order);
        dbHelper = new DBHelper(this);
    }

    public void loadData(){

        arrayList = dbHelper.getAllData();
        Log.d("size in all recipies",arrayList.size()+"");
        adapter = new MyAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

    }


}