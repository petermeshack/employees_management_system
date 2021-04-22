package com.project.sbem.supervisor.ui;

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
import com.project.sbem.data.model.EmployeesModelAdapter;
import com.project.sbem.data.model.LeaveModelAdapter;

import java.util.ArrayList;

public class LeavesFragment extends Fragment {
    RecyclerView list_all_users;
    DatabaseHelper db;
    ArrayList<String> Swork_leave_id,Sleave_Name,Sleave_start_date,Sleave_end_date;
    LeaveModelAdapter leaveModelAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_supervisor_leaves, container, false);

        Button updateLeaves = (Button) root.findViewById(R.id.grant_revoke);

        updateLeaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateLeavesActivity.class);
                startActivity(intent);
            }
        });

        list_all_users = root.findViewById(R.id.emp_leavelist_leaves);
        db = new DatabaseHelper(getContext());
        Swork_leave_id  = new ArrayList<>();
        Sleave_Name  = new ArrayList<>();
        Sleave_start_date  = new ArrayList<>();
        Sleave_end_date  = new ArrayList<>();


        storedata_in_Leave_array();
        leaveModelAdapter = new LeaveModelAdapter(getContext(),Swork_leave_id,Sleave_Name,Sleave_start_date,Sleave_end_date);
        list_all_users.setAdapter(leaveModelAdapter);
        list_all_users.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }

    void storedata_in_Leave_array(){
        Cursor cursor = db.readAllData_Leave();
        if(cursor.getCount()== 0){
            Toast.makeText(getContext(), "No Data available", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                Swork_leave_id.add(cursor.getString(1));
                Sleave_Name.add(cursor.getString(2));
                Sleave_start_date.add(cursor.getString(3));
                Sleave_end_date.add(cursor.getString(4));

            }
        }
    }
}