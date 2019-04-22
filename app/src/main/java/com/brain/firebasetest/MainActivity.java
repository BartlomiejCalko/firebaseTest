package com.brain.firebasetest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements OnCompleteListener<AuthResult>, OnFailureListener, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOk = (Button) findViewById(R.id.buttonOK);
        buttonOk.setOnClickListener(this);

        //mAuth = FirebaseAuth.getInstance();
        //mAuth.signInAnonymously().addOnCompleteListener(this).addOnFailureListener(this);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        Log.d(TAG, "onComplete: ");

    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Log.d(TAG, "onFailure: ");

    }

    @Override
    public void onClick(View view) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference().push().child("testObj").setValue("Test").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d(TAG, "onComplete: ");
            }
        });

    }
}
