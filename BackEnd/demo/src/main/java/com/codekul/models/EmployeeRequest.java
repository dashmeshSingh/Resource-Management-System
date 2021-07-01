package com.codekul.models;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class EmployeeRequest {


    private int empid;
    private String empname;
    private String email;
    private String reportingto;
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public String getEmpname() {
        return empname;
    }
    public void setEmpname(String empname) {
        this.empname =empname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getReportingto() {
        return reportingto;
    }
    public void setReportingto(String reportingto) {
        this.reportingto = reportingto;
    }

}
