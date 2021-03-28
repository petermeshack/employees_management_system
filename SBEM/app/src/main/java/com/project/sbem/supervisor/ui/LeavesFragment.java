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

public class LeavesFragment extends Fragment {

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

        return root;
    }
}