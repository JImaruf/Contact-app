package com.example.mycontact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mycontact.ContactAdapater.Adapter;
import com.example.mycontact.Database.RoomDB;
import com.example.mycontact.Models.ContactModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcview;
    FloatingActionButton addcontact;
    RoomDB database;
    ContactModel contactModel;
    Adapter adapter;
    Listener listener;
    List<ContactModel> contactModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcview = findViewById(R.id.recyclerview);

        addcontact = findViewById(R.id.floatingActionButton);


        database=RoomDB.getInstance(MainActivity.this);
        contactModelList = database.mainDao().getAll();
        updateRecyler(contactModelList);

        addcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ContactTakerActivity.class);

                startActivityForResult(intent,101);
            }
        });


        listener = new Listener() {
            @Override
            public void onclickListener() {
              Intent intent = new Intent(MainActivity.this,ContactTakerActivity.class);
//               intent.putExtra("oldContact",contactModel);
//               startActivityForResult(intent,102);
                startActivity(intent);

            }
        };
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101)
        {
            if(resultCode==RESULT_OK)
            {
                ContactModel newcontact = (ContactModel) data.getSerializableExtra("newcontact");
                database.mainDao().insert(newcontact);
                contactModelList.clear();
                contactModelList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();

            }
        }

    }

    public  void  updateRecyler(List<ContactModel> contactModelList)
    {
        adapter = new Adapter(contactModelList,MainActivity.this, listener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        rcview.setAdapter(adapter);
        rcview.setLayoutManager(linearLayoutManager);



    }



}