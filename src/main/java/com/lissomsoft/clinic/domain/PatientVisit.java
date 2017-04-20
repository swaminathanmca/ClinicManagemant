package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 07-Apr-17.
 */
public class PatientVisit {

    private Integer visit_id;
    private String patient_pid;
    private  String first_name;
    private String last_name;
    private Integer doctor_id;
    private Integer status;
    private Integer type;
    private Integer height;
    private Integer weight;
    private Integer pressure;
    private Integer branch_id;
    private String time;
    private String referal_details;

    public String getPatient_pid() {
        return patient_pid;
    }

    public void setPatient_pid(String patient_pid) {
        this.patient_pid = patient_pid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getProfile_id() {
        return doctor_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.doctor_id = doctor_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getReferal_details() {
        return referal_details;
    }

    public void setReferal_details(String referal_details) {
        this.referal_details = referal_details;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Integer getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Integer branch_id) {
        this.branch_id = branch_id;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    public  String toString(){
        return "PatientVisit {" +
                " visit_id ="+ visit_id +
                "patient_pid ="+ patient_pid +
                " first_name ="+ first_name +
                " last_name  ="+last_name +
                " doctor_id  ="+doctor_id+
                " type       ="+type+
                " height     ="+height+
                " weight     ="+weight+
                " branch_id  ="+branch_id+
                " time       ="+time+
                " status     ="+status+
                " pressure   ="+pressure+
                " referal_details ="+referal_details+
                '}';
    }
}
