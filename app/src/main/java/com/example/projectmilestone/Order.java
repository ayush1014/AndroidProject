package com.example.projectmilestone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity {

    String type,toppings;
    int price;
    TextView tv_total,tv_toppings,tv_type;
    EditText number;
    Button order_btn;
    DBHelper dbHelper;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        init();
        gettingIntent();
        settingValues();

        dbHelper = new DBHelper(this);
        i = new Intent(this,Listing.class);

        order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number.getText().toString().isEmpty()){
                    Toast.makeText(Order.this, "Please enter 919 number", Toast.LENGTH_SHORT).show();
                }
                else{
                    dbHelper.insert(type,price,toppings);
                    Toast.makeText(Order.this, "Order created successfully", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }

            }
        });

    }

    private void settingValues() {
        tv_total.setText("Your total is: "+price);
        tv_toppings.setText(toppings);
        tv_type.setText("Type: "+type);
    }

    private void gettingIntent() {
        type = getIntent().getStringExtra("type");
        price = getIntent().getIntExtra("price",0);
        toppings = getIntent().getStringExtra("toppings");
    }

    public void init(){
        tv_total = findViewById(R.id.textView_total);
        number = findViewById(R.id.editText_number);
        tv_type = findViewById(R.id.type);
        tv_toppings = findViewById(R.id.toppings);
        order_btn = findViewById(R.id.order_btn);
    }


}