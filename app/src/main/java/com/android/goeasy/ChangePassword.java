package com.android.goeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class ChangePassword extends AppCompatActivity {
    EditText newpassword,confirmpassword;
    Button save;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    String userId;
    TextView textView;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password2);

        newpassword=findViewById(R.id.newpass);
        confirmpassword=findViewById(R.id.confirmpass);
        save=findViewById(R.id.save);
        progressDialog=new ProgressDialog(this);
        textView=findViewById(R.id.back_to_profile);
        firebaseAuth= FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        user= FirebaseAuth.getInstance().getCurrentUser();
        userId=user.getUid();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChangePassword.this,Profile.class));
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

                if(newpassword.getText().toString().isEmpty() || confirmpassword.getText().toString().isEmpty())
                {
                    if(newpassword.getText().toString().isEmpty())
                        newpassword.setError("Enter new password");
                    else
                        confirmpassword.setError("Enter confirm Password");
                }

                else if (user!=null && newpassword.getText().toString().equals(confirmpassword.getText().toString()) )
                {
                    progressDialog.setMessage("Changing password Please wait...");
                    progressDialog.show();
                    user.updatePassword(newpassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                progressDialog.dismiss();

                                reference.child(userId).child("password").setValue(newpassword.getText().toString());
                                Toast.makeText(ChangePassword.this, "Password has been Changed", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(ChangePassword.this, LoginPage.class);
                                startActivity(i);
                            }

                            else
                            {
                                Toast.makeText(ChangePassword.this, "Password couldn't be changed", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(ChangePassword.this, "Password must be same....", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}