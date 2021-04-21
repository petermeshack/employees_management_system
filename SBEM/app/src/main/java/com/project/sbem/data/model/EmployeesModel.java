package com.project.sbem.data.model;

public class EmployeesModel {
    int employeeid;
    String work_id;
    String firstName;
    String lastName;
    String mobileNumber;
    String email;
    String salary;
    String hiredate;
    String department;
    String role;

    //constructor
    public EmployeesModel(int employeeid,String work_id, String firstName, String lastName, String mobileNumber, String email, String salary, String hiredate, String department, String role) {
        this.work_id = work_id;
        this.employeeid = employeeid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.salary = salary;
        this.hiredate = hiredate;
        this.department = department;
        this.role = role;
    }

    // to sring that will put evrything into a single string

    @Override
    public String toString() {
        return "EmployeesModel{" +
                "employeeid=" + employeeid +
                ", work_id='" + work_id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", salary='" + salary + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    // getters and setters

    public int getEmployeeid() {
        return employeeid;
    }

    public String StringgetEmployeeid() {
        String employeeids = Integer.toString(employeeid);
        return employeeids;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getWork_id() {
        return work_id;
    }

    public void setWork_id(String work_id) {
        this.work_id = work_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
