package com.project.sbem.owner.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.project.sbem.OwnerActivity;
import com.project.sbem.R;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.EmployeesModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    DatabaseHelper db ;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    ListView listwine;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_owner_home, container, false);

       // db = new DatabaseHelper(getContext());
        //listwine=(ListView)getActivity().findViewById(R.id.emp_employeelist);
        //List<EmployeesModel> everyone = db.getAllRecords();
        //adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,everyone);
        //listwine.setAdapter(adapter);

        return root;
    }
}