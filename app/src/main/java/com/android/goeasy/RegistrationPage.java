package com.android.goeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationPage extends AppCompatActivity {

    Button button;
    EditText name,contact,setPassword,reenterPassword,email;
    TextView textView;
    //String namepattern="[a-zA-Z)";
    String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String contactPattern="^[0-9]{10}$";

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button=findViewById(R.id.registerButton);
        setPassword=findViewById(R.id.setPasswordEdittext);
        reenterPassword=findViewById(R.id.reenterPasswordEdittext);
        textView=findViewById(R.id.textView);
        name=findViewById(R.id.fullnameEdittext);
        contact=findViewById(R.id.ContactEdittext);
        email=findViewById(R.id.emailEdittext);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    PerforAuth();
            }
        });
    }
    private void PerforAuth()
    {
        String Email=email.getText().toString();
        String Name=name.getText().toString();
        String Contact=contact.getText().toString();
        String Password=setPassword.getText().toString();
        String Resetpassword=reenterPassword.getText().toString();
        if(!Email.matches(emailPattern))
        {
            email.setError("Enter correct email");
        }
        else if(Contact.length()!=10)
        {
            contact.setError("Enter valid contact number");
        }
        else if (Password.isEmpty() || Password.length()<6)
        {
            setPassword.setError("Enter correct Password");
        }
        else if(!Password.equals(Resetpassword))
        {
            reenterPassword.setError("Password not matched both field");
        }
        else if (Name.isEmpty() || Name.length()<=1)
        {
            name.setError("Enter valid name");
        }
        else
        {
            progressDialog.setMessage("Please wait while Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        UserHelper user=new UserHelper(Name,Email,Contact,Password);
                        FirebaseDatabase.getInstance()
                                .getReference("Users")
                                .child(FirebaseAuth.getInstance()
                                        .getCurrentUser().getUid()).setValue(user)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(RegistrationPage.this, "Registration succesful", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        progressDialog.dismiss();

                        sendUserToNextActivity();
                        //Toast.makeText(RegistrationPage.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(RegistrationPage.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void sendUserToNextActivity() {
        Intent intent=new Intent(RegistrationPage.this,HomePage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}