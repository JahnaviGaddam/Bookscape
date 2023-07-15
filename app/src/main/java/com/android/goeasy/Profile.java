package com.android.goeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    TextView image,profile,textView2,name,contact,email,logout;
    ImageView Back;
    Button editProfile,ChangePassword;
    FirebaseDatabase database;
    FirebaseUser user;
    String userId;
    DatabaseReference userRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        image=findViewById(R.id.Image);
        profile=findViewById(R.id.Profile);
        name=findViewById(R.id.Name);
        contact=findViewById(R.id.Contact);
        email=findViewById(R.id.Email);
        logout=findViewById(R.id.Logout);
        Back=findViewById(R.id.back);
        editProfile=findViewById(R.id.EditProfile);
        ChangePassword=findViewById(R.id.Password);
        database=FirebaseDatabase.getInstance();
        userRef=database.getReference("Users");
        user= FirebaseAuth.getInstance().getCurrentUser();
        userId=user.getUid();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Profile.this,LoginPage.class));
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this,HomePage.class));
            }
        });
        userRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelper userProfile = snapshot.getValue(UserHelper.class);
                if(userProfile!=null)
                {
                    String n=userProfile.Name;
                    String e=userProfile.Email;
                    String c=userProfile.Contact;

                   image.setText(""+n.charAt(0));
                    profile.setText(n);
                    name.setText(n);
                    contact.setText(c);
                    email.setText(e);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this,EditProfile.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("contact",contact.getText().toString());
                startActivity(i);
            }
        });

        ChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, ChangePassword.class));

            }
        });
    }
    public void onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                startActivity(new Intent(Profile.this, HomePage.class));
                break;
            case R.id.category:
                startActivity(new Intent(Profile.this, Categories.class));
                break;
            case R.id.profile:
                startActivity(new Intent(Profile.this, Profile.class));
                break;
        }
    }
}