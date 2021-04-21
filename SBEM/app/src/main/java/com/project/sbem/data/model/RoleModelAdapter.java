package com.project.sbem.data.model;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.sbem.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RoleModelAdapter extends RecyclerView.Adapter<RoleModelAdapter.MyViewFolder> {
    Context context;
    ArrayList work_id, firstname, lastname,department,role;

    public RoleModelAdapter(Context context, ArrayList work_id, ArrayList firstname, ArrayList lastname, ArrayList department, ArrayList role) {
        this.context = context;
        this.work_id = work_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.role = role;
    }

    @NonNull
    @Override
    public MyViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_roles,parent,false);
        return new MyViewFolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewFolder holder, int position) {
        holder.text_work_id.setText(String.valueOf(work_id.get(position)));
        holder.text_firstname.setText(String.valueOf(firstname.get(position)));
        holder.text_lastname.setText(String.valueOf(lastname.get(position)));
        holder.text_department.setText(String.valueOf(department.get(position)));
        holder.text_role.setText(String.valueOf(role.get(position)));
    }

    @Override
    public int getItemCount() {
        return work_id.size();
    }

    public class MyViewFolder extends RecyclerView.ViewHolder {
       TextView text_work_id, text_firstname, text_lastname,text_department,text_role;
        public MyViewFolder(@NonNull View itemView) {
            super(itemView);
            text_work_id = itemView.findViewById(R.id.txt_emp_role_id);
            text_firstname = itemView.findViewById(R.id.txt_emp_role_name);
            text_lastname = itemView.findViewById(R.id.txt_emp_role_lastname);
            text_department = itemView.findViewById(R.id.txt_emp_role_department);
            text_role = itemView.findViewById(R.id.txt_emp_role_role);
        }
    }
}
