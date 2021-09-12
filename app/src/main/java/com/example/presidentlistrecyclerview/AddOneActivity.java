package com.example.presidentlistrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.presidentlistrecyclerview.databinding.ActivityAddOneBinding;

public class AddOneActivity extends AppCompatActivity {

    private ActivityAddOneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddOneActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddOneActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}