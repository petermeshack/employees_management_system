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

import com.project.sbem.R;
import com.project.sbem.data.model.AllocateDuties;
import com.project.sbem.data.model.AllocateDutiesAdapter;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.LeaveModelAdapter;

import java.util.ArrayList;

public class DutiesFragment extends Fragment {
    RecyclerView list_all_users;
    DatabaseHelper db;
    ArrayList<String> Swork_duty_id,Sduty_Name,Sduty_start_date,Sduty_end_date;
    AllocateDutiesAdapter allocateDutiesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_supervisor_duties, container, false);

        Button allocateDuties = (Button) root.findViewById(R.id.allocate_new_duties);

        allocateDuties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AllocateDutiesActivity.class);
                startActivity(i);
            }
        });
        list_all_users = root.findViewById(R.id.emp_dutylist_duties);
        db = new DatabaseHelper(getContext());
        Swork_duty_id  = new ArrayList<>();
        Sduty_Name  = new ArrayList<>();
        Sduty_start_date  = new ArrayList<>();
        Sduty_end_date  = new ArrayList<>();


        storedata_in_duty_array();
        allocateDutiesAdapter = new AllocateDutiesAdapter(getContext(),Swork_duty_id,Sduty_Name,Sduty_start_date,Sduty_end_date);
        list_all_users.setAdapter(allocateDutiesAdapter);
        list_all_users.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }
    void storedata_in_duty_array(){
        Cursor cursor = db.readAllData_Leave();
        if(cursor.getCount()== 0){
            Toast.makeText(getContext(), "No Data available", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                Swork_duty_id.add(cursor.getString(1));
                Sduty_Name.add(cursor.getString(2));
                Sduty_start_date.add(cursor.getString(3));
                Sduty_end_date.add(cursor.getString(4));

            }
        }
    }
}