package com.project.sbem.data.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.sbem.R;
import com.project.sbem.owner.ui.ChangeStatusDeptActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DepartmentModelAdapter extends RecyclerView.Adapter<DepartmentModelAdapter.MyViewFolder>{
    Context context;
    ArrayList  work_D_id, Department_Name, Department_creation_date;

    public DepartmentModelAdapter(Context context, ArrayList work_D_id, ArrayList department_Name, ArrayList department_creation_date) {
        this.context = context;
        this.work_D_id = work_D_id;
        this.Department_Name = department_Name;
        this.Department_creation_date = department_creation_date;
    }

    @NonNull
    @Override
    public MyViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_department,parent,false);
        return new DepartmentModelAdapter.MyViewFolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewFolder holder, int position) {
        holder.text_work_D_id.setText(String.valueOf(work_D_id.get(position)));
        holder.text_Department_Name.setText(String.valueOf(Department_Name.get(position)));
        holder.text_Department_creation_date.setText(String.valueOf(Department_creation_date.get(position)));
        holder.linearLayout_dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChangeStatusDeptActivity.class);
                intent.putExtra("id",String.valueOf(work_D_id.get(position)));
                intent.putExtra("department_name",String.valueOf(Department_Name.get(position)));
                intent.putExtra("department_start",String.valueOf(Department_creation_date.get(position)));
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return work_D_id.size();
    }


    public class MyViewFolder extends RecyclerView.ViewHolder {
        TextView text_work_D_id, text_Department_Name, text_Department_creation_date;
        LinearLayout linearLayout_dep;
        public MyViewFolder(@NonNull View itemView) {
            super(itemView);
            text_work_D_id= itemView.findViewById(R.id.txt_dep_id);
            text_Department_Name=itemView.findViewById(R.id.txt_dep_name);
            text_Department_creation_date=itemView.findViewById(R.id.txt_dep_lastname);
            linearLayout_dep = itemView.findViewById(R.id.my_row_dep_department);

        }
    }
}
