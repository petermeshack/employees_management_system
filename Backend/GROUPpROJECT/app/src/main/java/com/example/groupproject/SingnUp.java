package com.example.groupproject;

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

public class SingnUp extends AppCompatActivity {
    EditText addedEmailtxt, addedPasswordtxt, addedPasswordRtxt;
    Button Sigupbt, toLoginbt;
    String email,password,confirmPass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singn_up);
        mAuth = FirebaseAuth.getInstance();

        addedEmailtxt = findViewById(R.id.SingnupEmail);
        addedPasswordtxt = findViewById(R.id.SingnupPass);
        addedPasswordRtxt = findViewById(R.id.SingnupPassRepeat);
        Sigupbt = findViewById(R.id.SignBt);
        toLoginbt = findViewById(R.id.toLoginbtn);



        toLoginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

        Sigupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == Sigupbt){
                    email = addedEmailtxt.getText().toString().trim();
                    password = addedPasswordtxt.getText().toString().trim();
                    confirmPass = addedPasswordRtxt.getText().toString().trim();

                    if (email.isEmpty()){

                        addedEmailtxt.setError("Invalid Email!");
                        addedEmailtxt.requestFocus();


                    }else if (password.isEmpty()){

                        addedPasswordtxt.setError("Invalid password!");
                        addedPasswordtxt.requestFocus();

                    }else if (confirmPass.isEmpty()){

                        addedPasswordRtxt.setError("Invalid password!");
                        addedPasswordRtxt.requestFocus();

                    }else if (!confirmPass.equals(password)){

                        addedPasswordRtxt.setError("Passwords do not match!!");
                        addedPasswordRtxt.requestFocus();
                        addedPasswordtxt.setError("Passwords do not match!!");
                        addedPasswordtxt.requestFocus();

                    } else{

                        Sigupbt.setOnClickListener(new View.OnClickListener() {
                            final String emailinput = addedEmailtxt.getText().toString();
                            final String passwordinput = addedPasswordtxt.getText().toString();
                            @Override
                            public void onClick(View view) {
                                mAuth.createUserWithEmailAndPassword(emailinput,passwordinput).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast toast = Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_SHORT);
                                        toast.show();
                                        // send user to the main activity
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast toast = Toast.makeText(SingnUp.this,e.getMessage(), Toast.LENGTH_SHORT);
                                        toast.show();
                                    }
                                });

                            }
                        });
                    }
                }else if (v == toLoginbt){

                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }
        });

    }
}