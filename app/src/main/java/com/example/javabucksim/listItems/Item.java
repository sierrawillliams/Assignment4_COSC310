package com.example.javabucksim.listItems;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.javabucksim.R;

import java.util.Currency;

public class Item extends AppCompatActivity {

    TextView productName, smol, mid, chonk, one, two, three, price12oz, price16oz, price20oz;
    Button back;
    double price1, price2, price3, price4, price5, price6, price7, price8, price9, price10;
    double price11, price12, price13, price14, price15, price16, price17, price18, price19, price20;
    //    private DatabaseReference mDatabase;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        back = findViewById(R.id.backButton);
        productName = findViewById(R.id.productName);
        smol = findViewById(R.id.smol);
        mid = findViewById(R.id.mid);
        chonk = findViewById(R.id.chonk);
        one = findViewById(R.id.price_12oz);
        two = findViewById(R.id.price_16oz);
        three = findViewById(R.id.price_20oz);
        price12oz = findViewById(R.id.price12oz);
        price16oz = findViewById(R.id.price16oz);
        price20oz = findViewById(R.id.price20oz);
        picture = findViewById(R.id.photo);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("productName");
        productName.setText(name);

        if (name.equals("Pumpkin Spice Latte")){
            price12oz.setText("$4.75");
            price16oz.setText("$5.25");
            price20oz.setText("$5.75");
            picture.setImageResource(R.drawable.psl);
        }  else if (name.equals("Dark Roast")) {
            price12oz.setText("$2.25");
            price16oz.setText("$2.75");
            price20oz.setText("$3.25");
            picture.setImageResource(R.drawable.istockphoto_1143290013_612x612);
        }  else if (name.equals("Medium Roast")){
            price12oz.setText("$2.25");
            price16oz.setText("$2.75");
            price20oz.setText("$3.25");
            picture.setImageResource(R.drawable.medium);
        }  else if (name.equals("Blonde Roast")){
            price12oz.setText("$2.25");
            price16oz.setText("$2.75");
            price20oz.setText("$3.25");
            picture.setImageResource(R.drawable.blonde);
        }  else if (name.equals("Cappuccino")){
            price12oz.setText("$3.25");
            price16oz.setText("$3.75");
            price20oz.setText("$4.25");
            picture.setImageResource(R.drawable.cap);
        }  else if (name.equals("Iced Pumpkin Spice Latte")){
            price12oz.setText("$4.75");
            price16oz.setText("$5.25");
            price20oz.setText("$5.75");
            picture.setImageResource(R.drawable.icedpsl);
        }  else if (name.equals("Iced Coffee")){
            price12oz.setText("$2.25");
            price16oz.setText("$2.75");
            price20oz.setText("$3.25");
            picture.setImageResource(R.drawable.icedcof);
        }  else if (name.equals("Cold Brew")){
            price12oz.setText("$2.25");
            price16oz.setText("$2.75");
            price20oz.setText("$3.25");
            picture.setImageResource(R.drawable.coldbrew);
        }  else if (name.equals("Iced Cappuccino")){
            price12oz.setText("$3.25");
            price16oz.setText("$3.75");
            price20oz.setText("$4.25");
            picture.setImageResource(R.drawable.icedcap);
        }  else if (name.equals("Pumpkin Chai Latte")){
            price12oz.setText("$4.75");
            price16oz.setText("$5.25");
            price20oz.setText("$5.75");
            picture.setImageResource(R.drawable.pcl);
        }  else if (name.equals("Tea")){
            price12oz.setText("$2.25");
            price16oz.setText("$2.75");
            price20oz.setText("$3.25");
            picture.setImageResource(R.drawable.tea);
        }  else if (name.equals("Hot Chocolate")){
            price12oz.setText("$3.25");
            price16oz.setText("$3.75");
            price20oz.setText("$4.25");
            picture.setImageResource(R.drawable.hotchoc);
        }  else if (name.equals("Chai Latte")){
            price12oz.setText("$3.25");
            price16oz.setText("$3.75");
            price20oz.setText("$4.25");
            picture.setImageResource(R.drawable.chai);
        }  else if (name.equals("Matcha Latte")){
            price12oz.setText("$3.25");
            price16oz.setText("$3.75");
            price20oz.setText("$4.25");
            picture.setImageResource(R.drawable.matcha);
        }  else if (name.equals("Iced Pumpkin Chai Latte")){
            price12oz.setText("$4.75");
            price16oz.setText("$5.25");
            price20oz.setText("$5.75");
            picture.setImageResource(R.drawable.icedpcl);
        }  else if (name.equals("Iced Tea")){
            price12oz.setText("$2.25");
            price16oz.setText("$2.75");
            price20oz.setText("$3.25");
            picture.setImageResource(R.drawable.icedtea);
        }  else if (name.equals("Iced Chai Latte")){
            price12oz.setText("$3.25");
            price16oz.setText("$3.75");
            price20oz.setText("$4.25");
            picture.setImageResource(R.drawable.icedchai);
        }  else if (name.equals("Iced Matcha Latte")){
            price12oz.setText("$3.25");
            price16oz.setText("$3.75");
            price20oz.setText("$4.25");
            picture.setImageResource(R.drawable.icedmatch);
        } else if (name.equals("Juice")){
            smol.setText("Orange");
            mid.setText("Apple");
            chonk.setText("Cranberry");

            one.setText("Orange:");
            two.setText("Apple:");
            three.setText("Cranberry:");

            price12oz.setText("$3.25");
            price16oz.setText("$3.25");
            price20oz.setText("$3.25");

            picture.setImageResource(R.drawable.juice);
        } else if (name.equals("Flavour Shots")){
            smol.setText("Vanilla");
            mid.setText("Hazelnut");
            chonk.setText("Caramel");

            one.setText("Vanilla:");
            two.setText("Hazelnut:");
            three.setText("Caramel:");

            price12oz.setText("$0.25");
            price16oz.setText("$0.25");
            price20oz.setText("$0.25");

            picture.setImageResource(R.drawable.flavour);
        } else if (name.equals("Espresso")){
            smol.setText("One");
            mid.setText("Two");
            chonk.setText("Three");

            one.setText("One:");
            two.setText("Two:");
            three.setText("Three:");

            price12oz.setText("$0.75");
            price16oz.setText("$0.75");
            price20oz.setText("$0.75");

            picture.setImageResource(R.drawable.espresso);
        } else if (name.equals("Milk")){
            smol.setText("Splash");
            mid.setText("Normal");
            chonk.setText("Extra");

            one.setText("Splash:");
            two.setText("Normal:");
            three.setText("Extra:");

            price12oz.setText("$0.25");
            price16oz.setText("$0.50");
            price20oz.setText("$0.75");

            picture.setImageResource(R.drawable.milk);
        } else if (name.equals("Cream")){
            smol.setText("Splash");
            mid.setText("Normal");
            chonk.setText("Extra");

            one.setText("Splash:");
            two.setText("Normal:");
            three.setText("Extra:");

            price12oz.setText("$0.25");
            price16oz.setText("$0.50");
            price20oz.setText("$0.75");

            picture.setImageResource(R.drawable.cream);
        } else if (name.equals("Sugar")){
            smol.setText("One");
            mid.setText("Two");
            chonk.setText("Three");

            one.setText("One:");
            two.setText("Two:");
            three.setText("Three:");

            price12oz.setText("$0.25");
            price16oz.setText("$0.50");
            price20oz.setText("$0.75");

            picture.setImageResource(R.drawable.sugar);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}