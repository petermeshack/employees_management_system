package com.example.employeems.ui.departments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.employeems.MainActivity;
import com.example.employeems.R;

public class DepartmentView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments_view);
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