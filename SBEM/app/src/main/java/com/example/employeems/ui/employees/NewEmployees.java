package com.example.employeems.ui.employees;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.employeems.MainActivity;
import com.example.employeems.R;

public class NewEmployees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_employees);
    }
    public void openView(View view){
        Intent i = new Intent(getApplicationContext(), ViewEmployees.class);
        startActivity(i);
    }
    public void openRemove(View view){
        Intent i = new Intent(getApplicationContext(), TerminateEmployees.class);
        startActivity(i);
    }
    public void openAdd(View view){
        Intent i = new Intent(getApplicationContext(), NewEmployees.class);
        startActivity(i);
    }
    public void openHome(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}