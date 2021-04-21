package com.project.sbem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.EmployeesModelAdapter;
import com.project.sbem.owner.ui.NewEmployeeActivity;

import java.util.ArrayList;

public class Navigation_Control extends AppCompatActivity {
    RecyclerView list_all_users;
    FloatingActionButton add_data;
    DatabaseHelper db;
    ArrayList<String> work_id, firstname, lastname,mobilenumber,email,salary,hiredate,department,role;
    EmployeesModelAdapter employeesModelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation__control);


        list_all_users = findViewById(R.id.emp_employeelist);
        add_data = findViewById(R.id.add_info);
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Navigation_Control.this, NewEmployeeActivity.class);
                startActivity(intent);
            }
        });
        db = new DatabaseHelper(Navigation_Control.this);
        work_id = new ArrayList<>();
        firstname = new ArrayList<>();
        lastname = new ArrayList<>();
        mobilenumber = new ArrayList<>();
        email = new ArrayList<>();
        salary = new ArrayList<>();
        hiredate = new ArrayList<>();
        department = new ArrayList<>();
        role = new ArrayList<>();

        storedata_in_employye_array();
        employeesModelAdapter = new EmployeesModelAdapter(Navigation_Control.this,work_id, firstname, lastname,mobilenumber,email,salary,hiredate,department,role);
        list_all_users.setAdapter(employeesModelAdapter);
        list_all_users.setLayoutManager(new LinearLayoutManager(Navigation_Control.this));
    }
    void storedata_in_employye_array(){
        Cursor cursor = db.readAllData_employee();
        if(cursor.getCount()== 0){
            Toast.makeText(this, "No Data available", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                work_id.add(cursor.getString(1));
                firstname.add(cursor.getString(2));
                lastname.add(cursor.getString(3));
                mobilenumber.add(cursor.getString(4));
                email.add(cursor.getString(5));
                salary.add(cursor.getString(6));
                hiredate.add(cursor.getString(7));
                department.add(cursor.getString(8));
                role.add(cursor.getString(9));
            }
        }
    }
}