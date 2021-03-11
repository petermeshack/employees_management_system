package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Leaves extends AppCompatActivity {
    ImageView toHomel, toProfilel, toLeavesl, toConversationl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaves);

        toHomel = findViewById(R.id.HomeIvl);
        toProfilel = findViewById(R.id.ProfileIvl);
        toLeavesl = findViewById(R.id.LeavesIvl);
        toConversationl = findViewById(R.id.ConversationIvl);



        toHomel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            });
        toProfilel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), EmployeeProfile.class));
                    finish();
                }
            });
        toLeavesl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Leaves.class));
                finish();
            }
        });
        toConversationl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Policies.class));
                finish();
            }
        });
    }
}