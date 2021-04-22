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
import com.project.sbem.supervisor.ui.UpdateLeavesActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeaveModelAdapter extends RecyclerView.Adapter<LeaveModelAdapter.MyViewFolder>{
    Context context;
    ArrayList work_leave_id,leave_Name,leave_start_date,leave_end_date;

    public LeaveModelAdapter(Context context, ArrayList work_leave_id, ArrayList leave_Name, ArrayList leave_start_date, ArrayList leave_end_date) {
        this.context = context;
        this.work_leave_id = work_leave_id;
        this.leave_Name = leave_Name;
        this.leave_start_date = leave_start_date;
        this.leave_end_date = leave_end_date;
    }

    @NonNull
    @Override
    public MyViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_leave,parent,false);
        return new LeaveModelAdapter.MyViewFolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewFolder holder, int position) {
        holder.text_work_leave_id.setText(String.valueOf(work_leave_id.get(position)));
        holder.text_leave_Name.setText(String.valueOf(leave_Name.get(position)));
        holder.text_leave_start_date.setText(String.valueOf(leave_start_date.get(position)));
        holder.text_leave_end_date.setText(String.valueOf(leave_end_date.get(position)));
        holder.linearLayout_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateLeavesActivity.class);
                intent.putExtra("id",String.valueOf(work_leave_id.get(position)));
                intent.putExtra("leave_type",String.valueOf(leave_Name.get(position)));
                intent.putExtra("leave_start",String.valueOf(leave_start_date.get(position)));;
                intent.putExtra("leave_end",String.valueOf(leave_end_date.get(position)));
                context.startActivities(new Intent[]{intent});
            }
        });

    }

    @Override
    public int getItemCount() {
        return work_leave_id.size();
    }


    public class MyViewFolder extends RecyclerView.ViewHolder {
        TextView text_work_leave_id,text_leave_Name,text_leave_start_date,text_leave_end_date;
        LinearLayout linearLayout_leave;
        public MyViewFolder(@NonNull View itemView) {
            super(itemView);
            text_work_leave_id= itemView.findViewById(R.id.txt_leave_user_id);
            text_leave_Name= itemView.findViewById(R.id.txt_leave_name);
            text_leave_start_date= itemView.findViewById(R.id.txt_leave_start_date);
            text_leave_end_date= itemView.findViewById(R.id.txt_leave_end_date);
            linearLayout_leave = itemView.findViewById(R.id.my_row_leave_row);
        }
    }
}
