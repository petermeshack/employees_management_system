package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText emailtext, passwordtext;
    Button Loginbtn, signuptoshow;
    private FirebaseAuth mAuth;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();


        emailtext = findViewById(R.id.loginEmail);
        passwordtext = findViewById(R.id.loginPass);
        signuptoshow = findViewById(R.id.registertextview);
        Loginbtn = findViewById(R.id.loginBt);


        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == Loginbtn){
                    email = emailtext.getText().toString().trim();
                    password = passwordtext.getText().toString().trim();

                    if (email.isEmpty()){

                        emailtext.setError("Invalid Email!");
                        emailtext.requestFocus();


                    }else if (password.isEmpty()){

                        passwordtext.setError("Invalid Password!");
                        passwordtext.requestFocus();

                    }else{

                        mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast toast = Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_SHORT);
                                toast.show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast toast = Toast.makeText(LoginActivity.this,e.getMessage(), Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });

                    }
                }else if (v == signuptoshow){
                    startActivity(new Intent(getApplicationContext(), SingnUp.class));
                }
            }
        });

        signuptoshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SingnUp.class));
            }
        });

    }


}