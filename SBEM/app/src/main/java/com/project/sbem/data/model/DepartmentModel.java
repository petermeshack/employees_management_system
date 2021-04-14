package com.project.sbem.data.model;

public class DepartmentModel {
    int department_id;
    String work_D_id;
    String Department_Name;
    String Department_creation_date;

    public DepartmentModel(int department_id, String work_D_id, String department_Name, String department_creation_date) {
        this.department_id = department_id;
        this.work_D_id = work_D_id;
        this.Department_Name = department_Name;
        this.Department_creation_date = department_creation_date;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getWork_D_id() {
        return work_D_id;
    }

    public void setWork_D_id(String work_D_id) {
        this.work_D_id = work_D_id;
    }

    public String getDepartment_Name() {
        return Department_Name;
    }

    public void setDepartment_Name(String department_Name) {
        Department_Name = department_Name;
    }

    public String getDepartment_creation_date() {
        return Department_creation_date;
    }

    public void setDepartment_creation_date(String department_creation_date) {
        Department_creation_date = department_creation_date;
    }
}
