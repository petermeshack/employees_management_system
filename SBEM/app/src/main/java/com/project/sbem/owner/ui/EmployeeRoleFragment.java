package com.project.sbem.owner.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.sbem.R;

public class EmployeeRoleFragment extends Fragment {
    public EmployeeRoleFragment() {
        // Required empty public constructor
    }
    public static EmployeeRoleFragment newInstance(String param1, String param2) {
        EmployeeRoleFragment fragment = new EmployeeRoleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_role, container, false);
    }
}