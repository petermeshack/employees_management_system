package com.project.sbem.owner.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.sbem.R;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.DepartmentModelAdapter;
import com.project.sbem.data.model.EmployeesModelAdapter;

import java.util.ArrayList;

public class DepartmentsFragment extends Fragment {
    RecyclerView list_all_users;
    FloatingActionButton add_data;
    DatabaseHelper db;
    ArrayList<String> work_D_id, Department_Name, Department_creation_date;
    DepartmentModelAdapter departmentModelAdapter;





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_departments, container, false);

        Button createDept = root.findViewById(R.id.dept_create);
        Button changeStateDept = root.findViewById(R.id.dept_activate_deactivate);

        createDept.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), CreateDepartmentActivity.class);
            startActivity(i);
        });

        changeStateDept.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), ChangeStatusDeptActivity.class);
            startActivity(i);
        });

        list_all_users = root.findViewById(R.id.emp_employeelist_department);
        db = new DatabaseHelper(getContext());
        work_D_id=new ArrayList<>();
        Department_Name=new ArrayList<>();
        Department_creation_date=new ArrayList<>();

        storedata_in_Department_array();
        departmentModelAdapter = new DepartmentModelAdapter(getContext(),work_D_id, Department_Name, Department_creation_date);
        list_all_users.setAdapter(departmentModelAdapter);
        list_all_users.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }
    void storedata_in_Department_array(){
        Cursor cursor = db.readAllData_Department();
        if(cursor.getCount()== 0){
            Toast.makeText(getContext(), "No Data available", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                work_D_id.add(cursor.getString(1));
                Department_Name.add(cursor.getString(2));
                Department_creation_date.add(cursor.getString(3));
            }
        }
    }
}