package com.project.sbem.owner.ui;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.project.sbem.R;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.EmployeesModelAdapter;
import com.project.sbem.data.model.RoleModelAdapter;

import java.util.ArrayList;

public class EmployeeRoleFragment extends Fragment {
    RecyclerView list_all_users;
    DatabaseHelper db;
    ArrayList<String> work_id, firstname, lastname,department,role;
    RoleModelAdapter roleModelAdapter;

   /* public EmployeeRoleFragment() {
        // Required empty public constructor
    }
    public static EmployeeRoleFragment newInstance(String param1, String param2) {
        EmployeeRoleFragment fragment = new EmployeeRoleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root =  inflater.inflate(R.layout.fragment_employee_role, container, false);

       list_all_users = root.findViewById(R.id.emp_employeelist_role);
        db = new DatabaseHelper(getContext());
        work_id = new ArrayList<>();
        firstname = new ArrayList<>();
        lastname = new ArrayList<>();;
        department = new ArrayList<>();
        role = new ArrayList<>();

        storedata_in_employye_array();
        roleModelAdapter= new RoleModelAdapter(getContext(),work_id, firstname, lastname,department,role);
        list_all_users.setAdapter(roleModelAdapter);
        list_all_users.setLayoutManager(new LinearLayoutManager(getContext()));
       return root;
    }

    void storedata_in_employye_array(){
        Cursor cursor = db.readAllData_employeeRoles();
        if(cursor.getCount()== 0){
            Toast.makeText(getContext(), "No Data available", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                work_id.add(cursor.getString(1));
                firstname.add(cursor.getString(2));
                lastname.add(cursor.getString(3));
                department.add(cursor.getString(8));
                role.add(cursor.getString(9));
            }
        }
    }

}