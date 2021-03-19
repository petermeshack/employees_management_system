package com.example.employeems.ui.departments;

import android.content.Intent;
import android.os.Bundle;

import com.example.employeems.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.employeems.R;

public class DepartmentCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_add);
    }
    public void openView(View view){
        Intent i = new Intent(getApplicationContext(), DepartmentView.class);
        startActivity(i);
    }
    public void openRemove(View view){
        Intent i = new Intent(getApplicationContext(), DepartmentRemove.class);
        startActivity(i);
    }
    public void openAdd(View view){
        Intent i = new Intent(getApplicationContext(), DepartmentCreate.class);
        startActivity(i);
    }
    public void openHome(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}