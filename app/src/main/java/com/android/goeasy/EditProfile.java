package com.android.goeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity {
    EditText Name, Contact;

    Button button;
    String username,name,contact;
    DatabaseReference reference;
    TextView textView;
    FirebaseUser user;
    String contactPattern="^[0-9]{10}$";
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        reference= FirebaseDatabase.getInstance().getReference("Users");

        user= FirebaseAuth.getInstance().getCurrentUser();
        userId=user.getUid();

        Name = findViewById(R.id.ename);
        Contact = findViewById(R.id.econtact);
        button = findViewById(R.id.button1);
        textView = findViewById(R.id.back_to_profile);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditProfile.this,Profile.class));
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=Contact.getText().toString();
                if(!n.matches(contactPattern))
                {
                    Contact.setError("Enter valid number");
                }
                else if((isNameChanged() || isContactChanged())&&(isContactChanged() || isNameChanged()))
                {
                    Toast.makeText(EditProfile.this, "Data has been updated", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(EditProfile.this,Profile.class);
                    startActivity(i);
                }

                else
                {
                    Intent i = new Intent(EditProfile.this,Profile.class);
                    startActivity(i);
                }
            }
        });
        showAllUserData();
    }

    private boolean isContactChanged() {
        if(!contact.equals(Contact.getText().toString()))
        {
            reference.child(userId).child("contact").setValue(Contact.getText().toString());
            contact=Contact.getText().toString();
            return true;
        }
        else
        {
            return false;
        }
    }



    private boolean isNameChanged() {
        if(!name.equals(Name.getText().toString()))
        {
            reference.child(userId).child("name").setValue(Name.getText().toString());
            name=Name.getText().toString();
            return true;
        }else
        {
            return false;
        }

    }
    private void showAllUserData()
    {
        Intent data = getIntent();
       // username=data.getStringExtra("userId");
        name = data.getStringExtra("name");
        contact = data.getStringExtra("contact");


        Name.setText(name);
        Contact.setText(contact);
    }
}
