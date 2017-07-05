package com.lissomsoft.clinic.domain;

/**
 * Created by Admin on 6/16/2017.
 */

public class Appointment {

    private Integer appointment_id;
    private Integer branch_id;
    private String name;
    private Integer doctor_id;
    private String dov;
    private String patient_pid;
    private String time;
    private String contact_no;
    private String doctor_name;
    private Integer status;

    public Integer getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Integer branch_id) {
        this.branch_id = branch_id;
    }

    public String getDov() {
        return dov;
    }

    public void setDov(String dov) {
        this.dov = dov;
    }

    public Integer getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Integer appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getPatient_pid() {
        return patient_pid;
    }

    public void setPatient_pid(String patient_pid) {
        this.patient_pid = patient_pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString(){
    return "Appointment {" +
            "  appointment_id = "+ appointment_id +
            ", name = "+ name +
            ", branch_id ="+ branch_id +
            ", doctor_id = "+ doctor_id +
            ", dov = "+ dov +
            ", time ="+time+
            ", patient_pid="+patient_pid+
            ", contact_no="+contact_no+
            ", doctor_name="+doctor_name+
            ", status="+status+
            "}";
}
}
