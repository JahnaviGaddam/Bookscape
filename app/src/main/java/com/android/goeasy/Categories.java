package com.android.goeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Categories extends AppCompatActivity {
    
    GridView gridView;
    ImageView imageView;
    TextView textView;
    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        imageView = findViewById(R.id.grid_imageView);
        textView = findViewById(R.id.grid_textView);
        gridView = findViewById(R.id.categories_gridView);
        fillArray();
        GridAdapter gridAdapter = new GridAdapter(this,text,image);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(Categories.this,BooksList.class);
                String cate = text.get(i);
                intent.putExtra("cat",cate);
                startActivity(intent);
            }
        });
    }
    private void fillArray() {
        text.add("Dystopian");text.add("Fantasy");text.add("Mystery");text.add("Romance");text.add("Science Fiction");
        text.add("Young Adult");text.add("Ghost");text.add("History");
        text.add("Philosophy");text.add("Poetry");text.add("Epic");text.add("Adventure");

        image.add(R.drawable.dystopian);image.add(R.drawable.fantasy);image.add(R.drawable.mystery);
        image.add(R.drawable.romance);image.add(R.drawable.science_fiction);image.add(R.drawable.young_adult);
        image.add(R.drawable.ghost);image.add(R.drawable.history);image.add(R.drawable.philosophy);image.add(R.drawable.poetry);image.add(R.drawable.epic);
        image.add(R.drawable.adventure);
    }
    public void onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                startActivity(new Intent(Categories.this, HomePage.class));
                break;
            case R.id.category:
                startActivity(new Intent(Categories.this, Categories.class));
                break;

            case R.id.profile:
                startActivity(new Intent(Categories.this, Profile.class));
                break;
        }
    }

}