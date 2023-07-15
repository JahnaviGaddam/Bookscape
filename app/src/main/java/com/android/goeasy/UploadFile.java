package com.android.goeasy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadFile extends AppCompatActivity {

    Button selectfile,upload;
    TextView notify;
    Uri pdfUri;
    FirebaseStorage storage;
    FirebaseDatabase database;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file);
        selectfile = findViewById(R.id.select_file);
        storage= FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();

        upload = findViewById(R.id.upload);
        notify = findViewById(R.id.notify);
        selectfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(UploadFile.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selecctPdf();
                }
                else{
                    ActivityCompat.requestPermissions(UploadFile.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pdfUri!=null) {
                    uploadFile(pdfUri);
                }
                else
                {
                    Toast.makeText(UploadFile.this,"Select a file",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void uploadFile(Uri pdfUri) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File");
        progressDialog.setProgress(0);
        progressDialog.show();

       final String fileName = System.currentTimeMillis()+"";
        StorageReference storageReference = storage.getReference();
        storageReference.child("Uploads").child(fileName).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                       Task<Uri> url = taskSnapshot.getStorage().getDownloadUrl();
                        DatabaseReference reference = database.getReference();
                        reference.child(fileName).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(UploadFile.this, "File Successfully uploaded", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(UploadFile.this, "File not uploaded", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UploadFile.this, "File not uploaded", Toast.LENGTH_SHORT).show();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        int currentProgress = (int)(100*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                        progressDialog.setProgress(currentProgress);
                    }
                });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selecctPdf();
        }
        else
        {
            Toast.makeText(UploadFile.this, "Please provide permission", Toast.LENGTH_SHORT).show();
        }
    }

    private void selecctPdf()
    {
        Intent intent= new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==86 && resultCode==RESULT_OK && data!=null)
        {
            pdfUri = data.getData();
            notify.setText("A file is selected"+data.getData().getLastPathSegment());
        }
        else
        {
            Toast.makeText(UploadFile.this,"Please select a file",Toast.LENGTH_SHORT).show();
        }
    }
}