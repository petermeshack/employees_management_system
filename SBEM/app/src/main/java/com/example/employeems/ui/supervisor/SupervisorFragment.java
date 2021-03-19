package com.example.employeems.ui.supervisor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.employeems.R;

public class SupervisorFragment extends Fragment {

    private SupervisorViewModel supervisorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        supervisorViewModel =
                new ViewModelProvider(this).get(SupervisorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_supervisor, container, false);
        return root;
    }
}