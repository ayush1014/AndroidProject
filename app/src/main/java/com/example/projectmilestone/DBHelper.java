package com.example.projectmilestone;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;



public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String DATABASE_NAME="DB";


    String CREATE_TABLE = "CREATE TABLE orders (_id INTEGER PRIMARY KEY, order_type TEXT, price INTEGER, toppings TEXT)"; // UNIQUE


    public DBHelper(Context applicationcontext) {
        super(applicationcontext, DATABASE_NAME, null,1);
    }

    public ArrayList<order_details> getAllData()
    {
        ArrayList<order_details> list =new  ArrayList< >() ;
        db =this.getReadableDatabase();
        Log.d("status","inside get All data");
        String query = "select * FROM orders";
        Cursor result = db.rawQuery(query,null);


        for (result.moveToLast(); !result.isBeforeFirst(); result.moveToPrevious())
        {
            int id =result.getInt(0);
            String order_type = result.getString(1);
            int price = result.getInt(2);
            String toppings = result.getString(3);

            order_details o = new order_details(id,price,order_type,toppings);
            Log.d("ID",Integer.toString(id));
            Log.d("Type",order_type);
            Log.d("Price",Integer.toString(price));
            list.add(o);
        }
        db.close();
        return list;
    }

    public void insert(String order_type, int price, String toppings){
        db =this.getWritableDatabase();

        ContentValues OrderValues = new ContentValues();

        OrderValues.put("order_type", order_type);
        OrderValues.put("price", price);
        OrderValues.put("toppings", toppings);

        db.insert("orders", null, OrderValues);

    }





    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Orders","Payment table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}

