package com.example.projectmilestone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Toppings extends AppCompatActivity {
    ImageButton onion,tomato,capsicum,pineapple,olive,chicken,sausage,pepperoni;
    int topping_price = 0;
    Button order_btn;
    TextView tv_toppings;
    Intent i;
    ArrayList<String> toppings = new ArrayList<String>();
    String type,prev_text;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);


        type = getIntent().getStringExtra("type");
        price = getIntent().getIntExtra("price",0);


        init();
        i = new Intent(this,Order.class);
        clickListner();
    }

    private void clickListner() {
        onion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArray(v,1);
            }
        });

        tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArray(v,1);
            }
        });

        capsicum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArray(v,2);

            }
        });

        pineapple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArray(v,1);
            }
        });

        olive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArray(v,1);
            }
        });

        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArray(v,3);
            }
        });

        sausage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArray(v,3);
            }
        });

        pepperoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArray(v,2);
            }
        });

        order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("type",type);
                i.putExtra("price",(price + topping_price));
                i.putExtra("toppings",tv_toppings.getText().toString());

                startActivity(i);
            }
        });
    }



    public void populateArray(View v,int price){

        String id = v.getId()+"";
        String tag = v.getTag()+"";
        prev_text  = tv_toppings.getText().toString().replace("  ","");


        if(!toppings.contains(id))
        {
            toppings.add(id);
            tv_toppings.setText(prev_text +  tag +" ");
            topping_price+=price;

        }
        else
        {
            toppings.remove(id);
            prev_text = prev_text.replace(tag,"");
            tv_toppings.setText(prev_text);
            topping_price-=price;

        }

//        Log.d("List",toppings+"");
//        Log.d("Tag",tag);
//        Log.d("txt",prev_text);
    }

    public void init(){
        onion = findViewById(R.id.onions);
        tomato = findViewById(R.id.tomatoes);
        capsicum = findViewById(R.id.capsicums);
        pineapple = findViewById(R.id.pineapples);
        olive = findViewById(R.id.olives);
        chicken = findViewById(R.id.chicken);
        sausage = findViewById(R.id.sausage);
        pepperoni = findViewById(R.id.pepperoni);

        tv_toppings = findViewById(R.id.textView_toppings);
        order_btn = findViewById(R.id.order_btn);

    }
}