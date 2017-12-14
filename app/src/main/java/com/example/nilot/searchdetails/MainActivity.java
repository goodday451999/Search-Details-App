package com.example.nilot.searchdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editTextSearch;
    ArrayList<String> names;
    CustomAdapter adapter;


    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<String> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (String s : names) {
            //if the existing elements contains the search input
            if (s.toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filterdNames);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding a TextChangedListener
        //to call a method whenever there is some change on the EditText
/*        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });*/

        names = new ArrayList<>();

        names.add("Undergraduate (UG)");
        names.add("Postgraduate (UG)");
        names.add("Dual degree undergraduate and postgraduate (UG+PG)");
        names.add("Doctoral (PhD)");
        names.add("Dual degree postgraduate and doctoral (PG+PhD)");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        editTextSearch = (EditText) findViewById(R.id.editTextSearch);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CustomAdapter(names);

        recyclerView.setAdapter(adapter);

    }

}