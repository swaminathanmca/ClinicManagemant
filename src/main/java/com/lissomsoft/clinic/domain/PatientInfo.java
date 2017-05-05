package com.lissomsoft.clinic.domain;

import java.util.List;

/**
 * Created by Admin on 4/19/2017.
 */
public class PatientInfo {

    private Integer patient_info_id;
    private String patient_pid;
    private String first_name;
    private Integer doctor_id;
    private Integer branch_id;
    private String last_name;
    private Integer height;
    private Integer weight;
    private Integer pressure;
    private String refereal_details;
    private List<Complaint> complaint;
    private String procedures;
    private String diagnosis;
    private String date;


    public Integer getPatient_info_id() {
        return patient_info_id;
    }

    public void setPatient_info_id(Integer patient_info_id) {
        this.patient_info_id = patient_info_id;
    }

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

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public String getRefereal_details() {
        return refereal_details;
    }

    public void setRefereal_details(String refereal_details) {
        this.refereal_details = refereal_details;
    }


    public List<Complaint> getComplaint() {
        return complaint;
    }

    public void setComplaint(List<Complaint> complaint) {
        this.complaint = complaint;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString(){
        return "patientInfo{"+
                " patient_info_id ="+ patient_info_id +
                " patient_pid = "+ patient_pid +
                " first_name = "+ first_name +
                " last_name = "+ last_name +
                " branch_id ="+ branch_id +
                " doctor_id ="+ doctor_id +
                " height = "+ height +
                " weight = "+ weight +
                " pressure = "+ pressure +
                " refereal_details = "+ refereal_details +
                " complaint = "+ complaint +
                " procedures = "+ procedures +
                " diagnosis ="+ diagnosis +
                " date = "+ date +
                "}";
    }
}
