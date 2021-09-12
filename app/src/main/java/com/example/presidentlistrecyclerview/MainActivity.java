package com.example.presidentlistrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.presidentlistrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final String TAG = "Presidents App";

    List<President> presidentList = new ArrayList<President>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fillPresidentList();

        Log.d(TAG, "onCreate: " + presidentList.toString());
        Toast.makeText(this, "President count = " + presidentList.size(), Toast.LENGTH_SHORT).show();

        binding.btnAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddOneActivity.class);
                startActivity(intent);
            }
        });
    }

    private void fillPresidentList() {
        President p0 = new President(0, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/160px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1,"John Adams", 1796,"https://en.wikipedia.org/wiki/File:John_Adams,_Gilbert_Stuart,_c1800_1815.jpg");
        President p2 = new President(2, "Thomas Jefferson", 1800,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg/160px-Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg");
        President p3 = new President(3, "James Madison", 1808, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/James_Madison.jpg/160px-James_Madison.jpg");
        President p4 = new President(4, "James Monroe", 1816,"https://en.wikipedia.org/wiki/File:James_Monroe_White_House_portrait_1819.jpg");
        President p5 = new President(5,"John Quincy Adams", 1824, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/JQA_Photo.tif/lossy-page1-160px-JQA_Photo.tif.jpg");
        President p6 = new President(6,"Andrew Jackson",1828, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Andrew_jackson_head.jpg/165px-Andrew_jackson_head.jpg");
        President p7 = new President(7,"Martin Van Buren", 1826, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Martin_Van_Buren_edit.jpg/160px-Martin_Van_Buren_edit.jpg");
        President p8 = new President(8, "Willan H. Harrison",1840,"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/William_Henry_Harrison_daguerreotype_edit.jpg/160px-William_Henry_Harrison_daguerreotype_edit.jpg");
        President p9 = new President(9,"James K. Polk",1844,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/JKP.jpg/160px-JKP.jpg");

        presidentList.addAll(Arrays.asList(new President[]{ p0, p1, p2, p3, p4, p5, p6, p7, p8, p9 }));
    }
}