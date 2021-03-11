package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Duties extends AppCompatActivity {
    ImageView toHome, toProfile, toLeaves, toPolicies, toLogout, toDepartments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duties);

        toHome = findViewById(R.id.HomeIv2);
        toProfile = findViewById(R.id.ProfileIv2);
        toLeaves = findViewById(R.id.LeavesIv2);
        toPolicies = findViewById(R.id.PoliciesIv2);
        toDepartments = findViewById(R.id.DepatrmentIv2);
        toLogout = findViewById(R.id.LogoutIv2);

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