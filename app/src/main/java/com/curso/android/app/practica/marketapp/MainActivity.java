package com.curso.android.app.practica.marketapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //AdapterView: RecyclerView
    RecyclerView recyclerView;

    // Data Source
    List<Item> items = new ArrayList<>();

    // Adapter
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);

        Item item1 = new Item(R.drawable.beverage, "Beverage","Drinks and infusions");
        Item item2 = new Item(R.drawable.bread, "Bread","Crunchy supper companion");
        Item item3 = new Item(R.drawable.fruit, "Fruits","Two pieces a day");
        Item item4 = new Item(R.drawable.vegitables, "Vegetables","To feel fresh");
        Item item5 = new Item(R.drawable.milk, "Milk","Drinks and infusions");
        Item item6 = new Item(R.drawable.popcorn, "Popcorn","For watching your movies");

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        adapter = new MyAdapter(items);
        recyclerView.setAdapter(adapter);

        // Set Layout Manager
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));



    }
}