package com.example.employeems.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.employeems.ui.departments.DepartmentCreate;
import com.example.employeems.ui.departments.DepartmentRemove;
import com.example.employeems.ui.departments.DepartmentView;
import com.example.employeems.R;
import com.example.employeems.ui.employees.NewEmployees;
import com.example.employeems.ui.employees.TerminateEmployees;
import com.example.employeems.ui.employees.ViewEmployees;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button emp_new = (Button) root.findViewById(R.id.emp_new);
        Button dept_create = (Button) root.findViewById(R.id.dept_create);
        Button emp_view = (Button) root.findViewById(R.id.emp_view);
        Button dept_view = (Button) root.findViewById(R.id.dept_view);
        Button emp_terminate = (Button) root.findViewById(R.id.emp_terminate);
        Button dept_remove = (Button) root.findViewById(R.id.dept_remove);


        emp_new.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)      {
                Intent n = new Intent(getActivity(), NewEmployees.class);
                startActivity(n);
            }
        });

        dept_create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)      {
                Intent n = new Intent(getActivity(), DepartmentCreate.class);
                startActivity(n);
            }
        });

        emp_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)      {
                Intent n = new Intent(getActivity(), ViewEmployees.class);
                startActivity(n);
            }
        });

        dept_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)      {
                Intent n = new Intent(getActivity(), DepartmentView.class);
                startActivity(n);
            }
        });
        emp_terminate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)      {
                Intent n = new Intent(getActivity(), TerminateEmployees.class);
                startActivity(n);
            }
        });

        dept_remove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)      {
                Intent n = new Intent(getActivity(), DepartmentRemove.class);
                startActivity(n);
            }
        });

        return root;
    }
}