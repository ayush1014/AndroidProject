package com.example.projectmilestone;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RecipeViewHolder> {



    private Context mCtx;
    private List<order_details> productList;

    public MyAdapter(Context mCtx, List<order_details> productList) {
        this.mCtx = mCtx;
        this.productList = productList;

    }


    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recyclerview_template, null);
        return new RecipeViewHolder(view);
    }



    @Override
    public void onBindViewHolder(RecipeViewHolder holder, final int position) {
        final order_details order = productList.get(position); // getting single product item 1 by 1

        holder.id.setText(order.getId()+"");
        holder.type.setText(order.getOrder_type());
        holder.price.setText("$"+order.getPrice());
        //holder.toppings.setText(order.getToppings()+"");

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {

        TextView id,type,price,toppings;





        public RecipeViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.tv_id);
            type = itemView.findViewById(R.id.tv_type);
            price = itemView.findViewById(R.id.tv_price);
          //  toppings = itemView.findViewById(R.id.tv_toppings);


        }
    }





}
