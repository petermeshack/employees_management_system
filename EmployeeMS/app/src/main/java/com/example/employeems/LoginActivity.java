package com.example.employeems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    EditText userEmail, userPassword;
    Button Loginbtn;
    String email,password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();


        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        Loginbtn = findViewById(R.id.loginBtn);


        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == Loginbtn){
                    email = userEmail.getText().toString().trim();
                    password = userPassword.getText().toString().trim();

                    if (email.isEmpty()) {
                        userEmail.setError("E-mail field should not be empty!");
                        userPassword.requestFocus();

                    } else if (password.isEmpty()){
                        userPassword.setError("Password field cannot be empty!");
                        userPassword.requestFocus();

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
                }
            }
        });
    }


}