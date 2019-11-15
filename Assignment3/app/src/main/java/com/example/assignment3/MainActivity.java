package com.example.assignment3;


import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment3.Fragment.FavouriteFragment;
import com.example.assignment3.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // I want there to be a Fragment in the slot from the start
        Fragment fragment = new FavouriteFragment();


        bottomNavigationView = findViewById(R.id.design_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // menuItem = the item on the bottom nav view that was selected
                // The id's here belong to the items in the menu of the BottomnNavigationView
                // The menu is chunked out as bottom_nav_menu.xml in the res > menu folder
                if (menuItem.getItemId() == R.id.nav_favourite) {
                    Fragment fragment = new FavouriteFragment();

                    return true;
                } else if (menuItem.getItemId() == R.id.nav_search) {
                    Fragment fragment = new SearchFragment();

                    return true;


                }
                return false;
            }
        });


        ArrayList<cat> exampleList = new ArrayList<>();
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Abyssinian", "Active, Energetic, Independent, Intelligent, Gentle",
                "Egypt", "7 - 10"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Aegean", "Affectionate, Social, Intelligent, Playful, Active",
                "Greece","7  -  10"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "American Bobtail", "Intelligent, Interactive, Lively, Playful, Sensitive",
                "United States","7 - 16"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "British Shorthair", "Affectionate, Easy Going, Gentle, Loyal, Patient, calm",
                "United Kingdom","12 - 20"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Burmese", "Curious, Intelligent, Gentle, Social, Interactive, Playful, Lively",
                "Burma","6 - 12"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Burmilla", "Easy Going, Friendly, Intelligent, Lively, Playful, Social",
                "United Kingdom","6 - 13"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Cornish Rex", "Affectionate, Intelligent, Active, Curious, Playful",
                "United Kingdom","5 - 9"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Cymric", "Gentle, Loyal, Intelligent, Playful",
                "Canada","8 - 13"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Cyprus", "Affectionate, Social","Cyprus","8 - 16"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Javanese", "Active, Devoted, Intelligent, Playful","United States","5 - 10"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Scottish Fold", "Affectionate, Intelligent, Loyal, Playful, Social, Sweet, Loving",
                "United Kingdom","5 - 11"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Snowshoe", "Affectionate, Social, Intelligent, Sweet-tempered",
                "United States","7 - 12"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Somali", "Mischievous, Tenacious, Intelligent, Affectionate, Gentle, Interactive, Loyal",
                "Somali","6 - 12"));
        exampleList.add(new cat(R.drawable.ic_adb_black_24dp, "Sphynx", "Loyal, Inquisitive, Friendly, Quiet, Gentle",
                "Canada","6 - 12"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CatAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.cat_bar_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);


        return true;
    }

}
