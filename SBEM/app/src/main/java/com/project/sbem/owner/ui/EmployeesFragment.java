package com.project.sbem.owner.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.sbem.R;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.EmployeesModel;
import com.project.sbem.data.model.EmployeesModelAdapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeesFragment extends Fragment {
    RecyclerView list_all_users;
    DatabaseHelper db;
    ArrayList<String> work_id, firstname, lastname,mobilenumber,email,salary,hiredate,department,role;
    EmployeesModelAdapter employeesModelAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_employees, container, false);

        Button newEmployee = root.findViewById(R.id.new_employee);
        Button terminateEmployee = root.findViewById(R.id.terminate_employee);



        newEmployee.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), NewEmployeeActivity.class);
            startActivity(i);

        });

        terminateEmployee.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), TerminateEmployeeActivity.class);
            startActivity(i);
        });

        list_all_users = root.findViewById(R.id.emp_employeelist_employees);
        db = new DatabaseHelper(getContext());
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
        employeesModelAdapter = new EmployeesModelAdapter(getContext(),work_id, firstname, lastname,mobilenumber,email,salary,hiredate,department,role);
        list_all_users.setAdapter(employeesModelAdapter);
        list_all_users.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }
    void storedata_in_employye_array(){
        Cursor cursor = db.readAllData_employee();
        if(cursor.getCount()== 0){
            Toast.makeText(getContext(), "No Data available", Toast.LENGTH_SHORT).show();
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