package com.android.goeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot extends AppCompatActivity {
    EditText Email;
    Button reset;
    FirebaseAuth auth;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        Email=findViewById(R.id.email1);
        reset=findViewById(R.id.reset1);
        textView=findViewById(R.id.back_to_home);
        auth=FirebaseAuth.getInstance();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resetPassword();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Forgot.this, LoginPage.class));
            }
        });
    }

    public void resetPassword() {
        String email=Email.getText().toString().trim();
        if(email.isEmpty())
        {

            Email.setError("Email is Required");
            Email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Email.setError("Please Provide Valid Email!");
            Email.requestFocus();
            return ;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {

                    Toast.makeText(Forgot.this, "Check Your Email To Reset Your Password", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Forgot.this,LoginPage.class));
                    finish();
                }

                else
                {
                    Toast.makeText(Forgot.this, "Try Again Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}