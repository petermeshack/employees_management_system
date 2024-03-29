package com.project.sbem.data.model;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.sbem.R;
import com.project.sbem.UpdateUserInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeesModelAdapter extends RecyclerView.Adapter<EmployeesModelAdapter.MyViewFolder> {
    Context context;
    Activity activity;
    ArrayList work_id, firstname, lastname,mobilenumber,email,salary,hiredate,department,role;
    public EmployeesModelAdapter(Context context, ArrayList work_id, ArrayList firstname, ArrayList lastname, ArrayList mobilenumber, ArrayList email, ArrayList salary, ArrayList hiredate, ArrayList department, ArrayList role) {
        //this.activity = activity;
        this.context = context;
        this.work_id = work_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.salary = salary;
        this.hiredate = hiredate;
        this.department = department;
        this.role = role;
    }

    @NonNull
    @Override
    public MyViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewFolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewFolder holder, int position) {
        holder.text_work_id.setText(String.valueOf(work_id.get(position)));
        holder.text_firstname.setText(String.valueOf(firstname.get(position)));
        holder.text_lastname.setText(String.valueOf(lastname.get(position)));
        holder.text_mobilenumber.setText(String.valueOf(mobilenumber.get(position)));
        holder.text_email.setText(String.valueOf(email.get(position)));
        holder.text_salary.setText(String.valueOf(salary.get(position)));
        holder.text_hiredate.setText(String.valueOf(hiredate.get(position)));
        holder.text_department.setText(String.valueOf(department.get(position)));
        holder.text_role.setText(String.valueOf(role.get(position)));

        holder.row_update_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateUserInfo.class);
                intent.putExtra("id",String.valueOf(work_id.get(position)));
                intent.putExtra("firstname",String.valueOf(firstname.get(position)));
                intent.putExtra("lastname",String.valueOf(lastname.get(position)));
                intent.putExtra("mobilenumber",String.valueOf(mobilenumber.get(position)));
                intent.putExtra("email",String.valueOf(email.get(position)));
                intent.putExtra("salary",String.valueOf(salary.get(position)));
                intent.putExtra("hiredate",String.valueOf(hiredate.get(position)));
                intent.putExtra("department",String.valueOf(department.get(position)));
                intent.putExtra("role",String.valueOf(role.get(position)));
                //activity.startActivityForResult(intent,1);
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return work_id.size();
    }

    public class MyViewFolder extends RecyclerView.ViewHolder {
       TextView text_work_id, text_firstname, text_lastname,text_mobilenumber,text_email,text_salary,text_hiredate,text_department,text_role;
       LinearLayout row_update_layout;
       public MyViewFolder(@NonNull View itemView) {
            super(itemView);
            text_work_id = itemView.findViewById(R.id.txt_emp_id);
            text_firstname = itemView.findViewById(R.id.txt_emp_name);
            text_lastname = itemView.findViewById(R.id.txt_emp_lastname);
            text_mobilenumber = itemView.findViewById(R.id.txt_emp_mobilenumber);
            text_email = itemView.findViewById(R.id.txt_emp_email);
            text_salary = itemView.findViewById(R.id.txt_emp_salary);
            text_hiredate = itemView.findViewById(R.id.txt_emp_hiredate);
            text_department = itemView.findViewById(R.id.txt_emp_department);
            text_role = itemView.findViewById(R.id.txt_emp_role);
            row_update_layout = itemView.findViewById(R.id.my_row_row);
        }
    }
}
