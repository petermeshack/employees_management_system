package com.project.sbem.owner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import com.project.sbem.R;

public class DepartmentsFragment extends Fragment {

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

        return root;
    }
}