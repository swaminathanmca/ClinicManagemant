package com.lissomsoft.clinic.domain;

/**
 * Created by Admin on 4/19/2017.
 */
public class PatientInfo {

    private String patient_pid;
    private String first_name;
    private String last_name;
    private Integer height;
    private Integer weight;
    private Integer pressure;
    private String refereal_details;
    private Integer complaint_id;
    private String procedures;

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

    public Integer getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(Integer complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String toString(){
        return "patientInfo{"+
                "patient_pid = "+ patient_pid +
                "first_name = "+ first_name +
                "last_name = "+ last_name +
                "height = "+ height +
                "weight = "+ weight +
                "pressure = "+ pressure +
                "refereal_details = "+ refereal_details +
                "complaint_id = "+ complaint_id +
                " procedures = "+ procedures + "}";
    }
}
