package com.project.sbem.owner.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.sbem.Navigation_Control;
import com.project.sbem.OwnerActivity;
import com.project.sbem.R;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.EmployeesModel;
import com.project.sbem.data.model.EmployeesModelAdapter;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.app.ActivityCompat.recreate;

public class HomeFragment extends Fragment {
    RecyclerView list_all_users;
    FloatingActionButton add_data;
    DatabaseHelper db;
    ArrayList<String> work_id, firstname, lastname,mobilenumber,email,salary,hiredate,department,role;
    EmployeesModelAdapter employeesModelAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_owner_home, container, false);

        list_all_users = root.findViewById(R.id.emp_employeelist_home);
        add_data = root.findViewById(R.id.add_info_home);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewEmployeeActivity.class);
                startActivity(intent);
            }
        });
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
        list_all_users.setAdapter(employeesModelAdapter)  ;
        list_all_users.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }
/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate(getActivity());
        }
    }*/


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