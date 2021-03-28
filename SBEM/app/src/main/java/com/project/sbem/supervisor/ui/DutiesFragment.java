package com.project.sbem.supervisor.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.project.sbem.R;

public class DutiesFragment extends Fragment {

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

        return root;
    }
}