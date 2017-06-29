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

    public String toString(){
    return "Appointment {" +
            "appointment_id = "+ appointment_id +
            ",name = "+ name +
            "branch_id ="+ branch_id +
            ",doctor_id = "+ doctor_id +
            "'dov = "+ dov +
            "}";
}
}
