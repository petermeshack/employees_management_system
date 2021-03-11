package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class EmployeeRegistration extends AppCompatActivity {
    ImageView toHome, toProfile, toLeaves, toPolicies, toLogout, toDepartments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration);

        toHome = findViewById(R.id.HomeIv4);
        toProfile = findViewById(R.id.ProfileIv4);
        toLeaves = findViewById(R.id.LeavesIv4);
        toPolicies = findViewById(R.id.PoliciesIv4);
        toDepartments = findViewById(R.id.DepatrmentIv4);
        toLogout = findViewById(R.id.LogoutIv4);

        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        toProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EmployeeProfile.class));
                finish();
            }
        });
        toLeaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Leaves.class));
                finish();
            }
        });
        toPolicies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Policies.class));
                finish();
            }
        });
        toDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Departments.class));
                finish();
            }
        });

        toLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Splashscreen1.class));
                finish();
            }
        });
    }
}