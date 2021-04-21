package com.project.sbem.data.model;

public class LeaveModel {
    int leave_id;
    String work_leave_id;
    String leave_Name;
    String leave_start_date;
    String leave_end_date;

    public LeaveModel(int leave_id, String work_leave_id, String leave_Name, String leave_start_date, String leave_end_date) {
        this.leave_id = leave_id;
        this.work_leave_id = work_leave_id;
        this.leave_Name = leave_Name;
        this.leave_start_date = leave_start_date;
        this.leave_end_date = leave_end_date;
    }

    public int getLeave_id() {
        return leave_id;
    }

    public void setLeave_id(int leave_id) {
        this.leave_id = leave_id;
    }

    public String getWork_leave_id() {
        return work_leave_id;
    }

    public void setWork_leave_id(String work_leave_id) {
        this.work_leave_id = work_leave_id;
    }

    public String getLeave_Name() {
        return leave_Name;
    }

    public void setLeave_Name(String leave_Name) {
        this.leave_Name = leave_Name;
    }

    public String getLeave_start_date() {
        return leave_start_date;
    }

    public void setLeave_start_date(String leave_start_date) {
        this.leave_start_date = leave_start_date;
    }

    public String getLeave_end_date() {
        return leave_end_date;
    }

    public void setLeave_end_date(String leave_end_date) {
        this.leave_end_date = leave_end_date;
    }
}
