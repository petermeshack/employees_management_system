package com.project.sbem.owner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.project.sbem.R;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.EmployeesModel;

import java.util.List;

public class EmployeesFragment extends Fragment {

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



        return root;
    }
}