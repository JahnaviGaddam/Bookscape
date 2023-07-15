package com.android.goeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    TextView textView;
    RatingBar ratingBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        textView=findViewById(R.id.textView2);
        ratingBar=findViewById(R.id.ratingBar);
        button=findViewById(R.id.button);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Feedback.this, "Thanks for your Feedback", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Feedback.this,HomePage.class));
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(v==1)
                    textView.setText("Very Bad");
                else if(v==2)
                    textView.setText("Bad");
                else if(v==3)
                    textView.setText("Good");
                else if(v==4)
                    textView.setText("Very Good");
                else if(v==5)
                    textView.setText("Excellent");
                else
                {

                }
            }
        });
    }
}