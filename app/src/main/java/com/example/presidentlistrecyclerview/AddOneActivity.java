package com.example.presidentlistrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.presidentlistrecyclerview.databinding.ActivityAddOneBinding;

import java.util.List;

public class AddOneActivity extends AppCompatActivity {

    private ActivityAddOneBinding binding;
    int id;

    MyApplication myApplication = (MyApplication) this.getApplication();

    List<President> presidentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presidentList = MyApplication.getPresidentList();

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        President president = null;

        if (id >= 0){
            // edit the president
            for (President p: presidentList){
                if (p.getId() == id){
                    president = p;
                }
            }
            binding.etName.setText(president.getName());
            binding.etDate.setText(String.valueOf(president.getDateOfElection()));
            binding.etURL.setText(president.getImageURL());
            binding.tvNumber.setText(String.valueOf(id));
        } else{
            // create new president
        }

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id >= 0){
                    // update
                    President updatePresident = new President(id, binding.etName.getText().toString(),
                            Integer.parseInt(binding.etDate.getText().toString()), binding.etURL.getText().toString());
                    presidentList.set(id, updatePresident);
                } else {
                    // add new president
                    // Create President object
                    int nextId = myApplication.getNextId();
                    President newPresident = new President(nextId, binding.etName.getText().toString(),
                            Integer.parseInt(binding.etDate.getText().toString()), binding.etURL.getText().toString());

                    // Add the object to the list of presidents
                    presidentList.add(newPresident);
                    myApplication.setNextId(nextId++);
                }



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