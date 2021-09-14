package com.example.presidentlistrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.presidentlistrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final String TAG = "Presidents App";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Menu menu;

    MyApplication myApplication = (MyApplication) this.getApplication();

    List<President> presidentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presidentList = MyApplication.getPresidentList();

        Log.d(TAG, "onCreate: " + presidentList.toString());
        Toast.makeText(this, "President count = " + presidentList.size(), Toast.LENGTH_SHORT).show();

        binding.btnAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddOneActivity.class);
                startActivity(intent);
            }
        });

        binding.lvPresidentList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        binding.lvPresidentList.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(presidentList, MainActivity.this);
        binding.lvPresidentList.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAZ:
                Collections.sort(presidentList, President.PresidentAZComparator);
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menuZA:
                Collections.sort(presidentList, President.PresidentZAComparator);
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menuASC:
                Collections.sort(presidentList, President.PresidentDateAscComparator);
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menuDESC:
                Collections.sort(presidentList, President.PresidentDateDesComparator);
                mAdapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}