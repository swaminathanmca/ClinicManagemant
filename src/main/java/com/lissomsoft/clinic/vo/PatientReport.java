package com.lissomsoft.clinic.vo;

import com.lissomsoft.clinic.domain.Complaint;

import java.util.List;

/**
 * Created by Lissomsoft on 05/19/17.
 */
public class PatientReport {

    private Integer patient_info_id;
    private Integer patient_id;
    private String patient_pid;
    private String first_name;
    private String last_name;
    private String referal_details;
    private String date;
    private Integer branch_id;
    private Integer doctor_id;
    private String procedures;
    private String diagonics;
    private String investigation;
    private String observation;
    private Integer type;
    private Integer bp;
    private List<Complaint> complaints;

    public Integer getPatient_info_id() {
        return patient_info_id;
    }

    public void setPatient_info_id(Integer patient_info_id) {
        this.patient_info_id = patient_info_id;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
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

    public String getReferal_details() {
        return referal_details;
    }

    public void setReferal_details(String referal_details) {
        this.referal_details = referal_details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Integer branch_id) {
        this.branch_id = branch_id;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getDiagonics() {
        return diagonics;
    }

    public void setDiagonics(String diagonics) {
        this.diagonics = diagonics;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInvestigation() {
        return investigation;
    }

    public void setInvestigation(String investigation) {
        this.investigation = investigation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public Integer getBp() {
        return bp;
    }

    public void setBp(Integer bp) {
        this.bp = bp;
    }

    public String toString(){
        return "PatientReport ="+
                "patient_info_id ="+patient_info_id+
                "patient_id ="+patient_id+
                "patient_pid ="+patient_pid+
                "first_name ="+first_name+
                "last_name ="+last_name+
                "referal_details ="+referal_details+
                "date ="+date+
                "procedures ="+procedures+
                "diagonics ="+diagonics+
                "investigation ="+investigation+
                "observation ="+observation+
                "type ="+type+
                "bp ="+bp+
                "complaints="+complaints+
                "}";
    }
}
