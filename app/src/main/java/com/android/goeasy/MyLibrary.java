package com.android.goeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class MyLibrary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_library);
    }
    public void onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                startActivity(new Intent(MyLibrary.this, HomePage.class));
                break;
            case R.id.category:
                startActivity(new Intent(MyLibrary.this, Categories.class));
                break;

            case R.id.profile:
                startActivity(new Intent(MyLibrary.this, Profile.class));
                break;
        }
    }
}