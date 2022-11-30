package com.example.javabucksim.listItems;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.example.javabucksim.MainActivity;
import com.example.javabucksim.R;
import com.example.javabucksim.orders.autoOrder;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.HashMap;

public class Categories extends AppCompatActivity {
//    implements NavigationView.OnNavigationItemSelectedListener {
//    menu
//    DrawerLayout drawerLayout;
//    NavigationView navigationView;
//    Toolbar toolbar;
//    //menuName & email
//    TextView menuName;
//    TextView menuEmail;
//    String menuFirstNameString;
//    String menuLastNameString;
//    String menuEmailString;
//    FirebaseUser user;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mFirebaseAuth;
    int[] productNum = new int[18];
    String[] productName = {"chai", "blondeRoast", "capp", "coffee", "coldbrew", "cups", "darkRoast", "flavour", "juice", "latte", "lids", "matcha", "mediumRoast", "milk", "sleeves", "stoppers", "sugar", "tea"};
    String[] categories = {"Hot Coffees", "Cold Coffees", "Hot Drinks", "Cold Drinks", "Other"};
    SearchView searchView;
    ListView products;
    Button back, check;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        //initialize buttons
        back = findViewById(R.id.backButton);
        check = findViewById(R.id.check);
        //initialize searchView for the search bar
        searchView = findViewById(R.id.search_bar);
        //initialize listView for the product list
        products = findViewById(R.id.productList);

        //if back is clicked go to MainActivity.java
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //if a product from the listView is clicked, go to Choices.java and pass the values to it
        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(Categories.this, Choices.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("category", productInfo[0][0]);
                    bundle.putString("choice1", productInfo[0][1]);
                    bundle.putString("choice2", productInfo[0][2]);
                    bundle.putString("choice3", productInfo[0][3]);
                    bundle.putString("choice4", productInfo[0][4]);
                    bundle.putString("choice5", productInfo[0][5]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 1){
                    Intent intent = new Intent(Categories.this, Choices.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("category", productInfo[1][0]);
                    bundle.putString("choice1", productInfo[1][1]);
                    bundle.putString("choice2", productInfo[1][2]);
                    bundle.putString("choice3", productInfo[1][3]);
                    bundle.putString("choice4", productInfo[1][4]);
                    bundle.putString("choice5", productInfo[1][5]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 2){
                    Intent intent = new Intent(Categories.this, Choices.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("category", productInfo[2][0]);
                    bundle.putString("choice1", productInfo[2][1]);
                    bundle.putString("choice2", productInfo[2][2]);
                    bundle.putString("choice3", productInfo[2][3]);
                    bundle.putString("choice4", productInfo[2][4]);
                    bundle.putString("choice5", productInfo[2][5]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 3){
                    Intent intent = new Intent(Categories.this, Choices.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("category", productInfo[3][0]);
                    bundle.putString("choice1", productInfo[3][1]);
                    bundle.putString("choice2", productInfo[3][2]);
                    bundle.putString("choice3", productInfo[3][3]);
                    bundle.putString("choice4", productInfo[3][4]);
                    bundle.putString("choice5", productInfo[4][5]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(i == 4){
                    Intent intent = new Intent(Categories.this, Choices.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("category", productInfo[4][0]);
                    bundle.putString("choice1", productInfo[4][1]);
                    bundle.putString("choice2", productInfo[4][2]);
                    bundle.putString("choice3", productInfo[4][3]);
                    bundle.putString("choice4", productInfo[4][4]);
                    bundle.putString("choice5", productInfo[4][5]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

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

//        sa = new SimpleAdapter(Categories.this, list1, R.layout.activity_items_list, new String[]{"line1"}, new int[]{R.id.textView1});
//        ((ListView) findViewById(R.id.productList)).setAdapter(sa);

        //adapter to produce the listview
        aa = new ArrayAdapter<String>(this, R.layout.activity_items_list, R.id.textView1, categories);
        products.setAdapter(aa);

        //if check is clicked, go to the lowStockWarning method
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lowStockWarning();
            }
        });
    }

    void lowStockWarning() {
        String doc = "j9BQe3OtLP6XnUK66MWK";
        DocumentReference documentReference = db.collection("Inventory").document(doc);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                productNum[0] = Integer.parseInt(value.getString(productName[0]));
                productNum[1] = Integer.parseInt(value.getString(productName[1]));
                productNum[2] = Integer.parseInt(value.getString(productName[2]));
                productNum[3] = Integer.parseInt(value.getString(productName[3]));
                productNum[4] = Integer.parseInt(value.getString(productName[4]));
                productNum[5] = Integer.parseInt(value.getString(productName[5]));
                productNum[6] = Integer.parseInt(value.getString(productName[6]));
                productNum[7] = Integer.parseInt(value.getString(productName[7]));
                productNum[8] = Integer.parseInt(value.getString(productName[8]));
                productNum[9] = Integer.parseInt(value.getString(productName[9]));
                productNum[10] = Integer.parseInt(value.getString(productName[10]));
                productNum[11] = Integer.parseInt(value.getString(productName[11]));
                productNum[12] = Integer.parseInt(value.getString(productName[12]));
                productNum[13] = Integer.parseInt(value.getString(productName[13]));
                productNum[14] = Integer.parseInt(value.getString(productName[14]));
                productNum[15] = Integer.parseInt(value.getString(productName[15]));
                productNum[16] = Integer.parseInt(value.getString(productName[16]));
                productNum[17] = Integer.parseInt(value.getString(productName[17]));

                alert();
            }
        });
    }

    public void alert() {
        Button check = findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Categories.this);
                for (int i = 0; i < productNum.length; i++) {
                    if (productNum[i] < 50)
                    {
                        builder.setCancelable(true);
                        builder.setTitle("Low stock warning");
                        builder.setMessage("Please resupply " + productName[i] + ":");
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                        builder.setPositiveButton("Order now", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                openOrderActivity();
                            }
                        });

                        builder.show();
                        break;
                    }
                }
            }
        });
    }
    public void openOrderActivity() {
        Intent intent = new Intent(this, autoOrder.class);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.nav_search);
        SearchView searchView = (SearchView) searchViewItem.getActionView();
        searchView.setQueryHint("Search");

        return super.onCreateOptionsMenu(menu);
    }

    private String[][] productInfo = {
            {"Hot Coffees", "Pumpkin Spice Latte", "Dark Roast", "Medium Roast", "Blonde Roast", "Cappuccino"},
            {"Cold Coffees", "Iced Pumpkin Spice Latte", "Iced Coffee", "Iced Latte", "Cold Brew", "Iced Cappuccino"},
            {"Hot Drinks", "Pumpkin Chai Latte", "Tea", "Hot Chocolate", "Chai Latte", "Matcha Latte"},
            {"Cold Drinks", "Iced Pumpkin Chai Latte", "Iced Tea", "Iced Chai Latte", "Iced Matcha Latte", "Juice"},
            {"Other", "Flavour Shots", "Espresso", "Milk", "Cream", "Sugar"}};
}
//menu
//        drawerLayout = findViewById(R.id.drawer_layout);
//        navigationView = findViewById(R.id.nav_view);
//        toolbar = findViewById(R.id.toolbar);
//
//        //toolbar
//        setSupportActionBar(toolbar);
//        //nav_drawer
//        navigationView.bringToFront();
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        drawerLayout.setScrimColor(Color.parseColor("#32000000"));
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(this);
//        //headerInfo
//        setMenuNameAndEmail();

//    @Override
//    public void onBackPressed() {
//
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    //menuMethods
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.nav_home:
//                break;
//            case R.id.nav_place_order:
//                Intent intent = new Intent(Categories.this,autoOrder.class);
//                startActivity(intent);
//                break;
//            case R.id.nav_veiw_items:
//                Intent intent1 = new Intent(Categories.this,Categories.class);
//                startActivity(intent1);
//                break;
//            case R.id.nav_profile:
//                Intent intent2 = new Intent(Categories.this,settingsActivity.class);
//                startActivity(intent2);
//                break;
//            case R.id.nav_logout:
//                mFirebaseAuth.signOut();
//                Intent intent3 = new Intent(Categories.this, MainActivity.class);
//                startActivity(intent3);
//                finish();
//                break;
//            case R.id.nav_veiw_report:
//                Intent intent4 = new Intent(Categories.this, reportActivity.class);
//                startActivity(intent4);
//                break;
//        }
//        return true;
//    }
//    void setMenuNameAndEmail() {
//        user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//
//
//        DocumentReference documentReference = db.collection("users").document(uid);
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                menuFirstNameString = value.getString("firstName");
//                menuLastNameString = value.getString("lastName");
//                menuEmailString = value.getString("email");
//                View headView = navigationView.getHeaderView(0);
//                TextView navUserName = (TextView) headView.findViewById(R.id.menuName);
//                TextView navUserEmail = (TextView) headView.findViewById(R.id.menuEmail);
//                navUserName.setText(menuFirstNameString + " " + menuLastNameString);
//                navUserEmail.setText(menuEmailString);
//            }
//        });
//    }

//      hotCof.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                category = "Hot Coffees";
//                choice1 = "Pumpkin Spice Latte";
//                choice2 = "Dark Roast";
//                choice3 = "Medium Roast";
//                choice4 = "Blonde Roast";
//                choice5 = "Cappuccino";
//                Intent intent = new Intent(Categories.this, Choices.class);
//                intent.putExtra("category", category);
//                intent.putExtra("choice1", choice1);
//                intent.putExtra("choice2", choice2);
//                intent.putExtra("choice3", choice3);
//                intent.putExtra("choice4", choice4);
//                intent.putExtra("choice5", choice5);
//                startActivity(intent);
//            }
//        });
//
//        coldCof.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                category = "Cold Coffees";
//                choice1 = "Iced Pumpkin Spice Latte";
//                choice2 = "Iced Coffee";
//                choice3 = "Iced Latte";
//                choice4 = "Cold Brew";
//                choice5 = "Iced Cappuccino";
//                Intent intent = new Intent(Categories.this, Choices.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("category", category);
//                bundle.putString("choice1", choice1);
//                bundle.putString("choice2", choice2);
//                bundle.putString("choice3", choice3);
//                bundle.putString("choice4", choice4);
//                bundle.putString("choice5", choice5);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });
//
//        hotD.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                category = "Hot Drinks";
//                choice1 = "Pumpkin Chai Latte";
//                choice2 = "Tea";
//                choice3 = "Hot Chocolate";
//                choice4 = "Chai Latte";
//                choice5 = "Matcha Latte";
//                Intent intent = new Intent(Categories.this, Choices.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("category", category);
//                bundle.putString("choice1", choice1);
//                bundle.putString("choice2", choice2);
//                bundle.putString("choice3", choice3);
//                bundle.putString("choice4", choice4);
//                bundle.putString("choice5", choice5);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });
//
//        coldD.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                category = "Cold Drinks";
//                choice1 = "Iced Pumpkin Chai Latte";
//                choice2 = "Iced Tea";
//                choice3 = "Iced Chai Latte";
//                choice4 = "Iced Matcha Latte";
//                choice5 = "Juice";
//                Intent intent = new Intent(Categories.this, Choices.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("category", category);
//                bundle.putString("choice1", choice1);
//                bundle.putString("choice2", choice2);
//                bundle.putString("choice3", choice3);
//                bundle.putString("choice4", choice4);
//                bundle.putString("choice5", choice5);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });
//
//        other.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                category = "Other";
//                choice1 = "Flavour Shots";
//                choice2 = "Espresso";
//                choice3 = "Milk";
//                choice4 = "Cream";
//                choice5 = "Sugar";
//                Intent intent = new Intent(Categories.this, Choices.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("category", category);
//                bundle.putString("choice1", choice1);
//                bundle.putString("choice2", choice2);
//                bundle.putString("choice3", choice3);
//                bundle.putString("choice4", choice4);
//                bundle.putString("choice5", choice5);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });
