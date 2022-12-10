package com.example.javabucksim.listItems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.javabucksim.R;

public class Choices extends AppCompatActivity {

    Button back;
    TextView category;
    String cat, c1, c2, c3, c4, c5;
    ListView items;
    ArrayAdapter<String> aa;
    String[] choices;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);

        back = findViewById(R.id.backButton);
        category = findViewById(R.id.category);
        items = findViewById(R.id.itemList);
        searchView = findViewById(R.id.search);

        Bundle bundle = getIntent().getExtras();
        cat = bundle.getString("category");
        c1 = bundle.getString("choice1");
        c2 = bundle.getString("choice2");
        c3 = bundle.getString("choice3");
        c4 = bundle.getString("choice4");
        c5 = bundle.getString("choice5");

        choices  = new String[]{c1, c2, c3, c4, c5};

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //if an item from the listView is clicked, go to Item.java and pass the values to it
        items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    String productName = c1;
                    Intent intent = new Intent(Choices.this, Item.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("productName", productName);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 1){
                    String productName = c2;
                    Intent intent = new Intent(Choices.this, Item.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("productName", productName);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 2){
                    String productName = c3;
                    Intent intent = new Intent(Choices.this, Item.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("productName", productName);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 3){
                    String productName = c4;
                    Intent intent = new Intent(Choices.this, Item.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("productName", productName);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 4){
                    String productName = c5;
                    Intent intent = new Intent(Choices.this, Item.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("productName", productName);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });


        aa = new ArrayAdapter<String>(this, R.layout.activity_items_list, R.id.textView1, choices);
        items.setAdapter(aa);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                aa.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                aa.getFilter().filter(newText);
                return false;
            }
        });
    }
}


//choice1.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        String productName = c1;
//        Intent intent = new Intent(Choices.this, Item.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("productName", productName);
//        intent.putExtras(bundle);
//        startActivity(intent);
//        }
//
//        });
//
//        choice2.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        String productName = c2;
//        Intent intent = new Intent(Choices.this, Item.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("productName", productName);
//        intent.putExtras(bundle);
//        startActivity(intent);
//        }
//        });
//
//        choice3.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        String productName = c3;
//        Intent intent = new Intent(Choices.this, Item.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("productName", productName);
//        intent.putExtras(bundle);
//        startActivity(intent);
//        }
//        });
//
//        choice4.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        String productName = c4;
//        Intent intent = new Intent(Choices.this, Item.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("productName", productName);
//        intent.putExtras(bundle);
//        startActivity(intent);
//        }
//        });
//
//        choice5.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        String productName = c5;
//        Intent intent = new Intent(Choices.this, Item.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("productName", productName);
//        intent.putExtras(bundle);
//        startActivity(intent);
//        }
//        });