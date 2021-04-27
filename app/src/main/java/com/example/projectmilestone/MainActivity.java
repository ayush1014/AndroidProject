package com.example.projectmilestone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ImageButton pizza1,pizza2,pizza3,pizza4;
    Button start_btn;
    TextView tv_price;
    String pizza_type = "";
    int price = 0;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        i = new Intent(this,Toppings.class);
        clickListner();
    }

    public void init(){
        pizza1 = findViewById(R.id.pizza1);
        pizza2 = findViewById(R.id.pizza2);
        pizza3 = findViewById(R.id.pizza3);
        pizza4 = findViewById(R.id.pizza4);
        start_btn = findViewById(R.id.start_btn);
        tv_price = findViewById(R.id.textView_price);
    }

    public void clickListner(){
        pizza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = 40;
                tv_price.setText("Price: $"+price);
                pizza_type = "Veggie";

            }
        });

        pizza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = 50;
                tv_price.setText("Price: $"+price);
                pizza_type = "Chicken";
            }
        });

        pizza3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = 60;
                tv_price.setText("Price: $"+price);
                pizza_type = "Pepperoni";
            }
        });

        pizza4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = 70;
                tv_price.setText("Price: $"+price);
                pizza_type = "Sausage";
            }
        });

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("type",pizza_type);
                i.putExtra("price",price);
                startActivity(i);
            }
        });

    }



}