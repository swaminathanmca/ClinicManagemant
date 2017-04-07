package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 07-Apr-17.
 */
public class PatientVisit {

    private Integer patient_pid;
    private  String first_name;
    private String last_name;
    private Integer profile_id;
    private Integer type;
    private Integer height;
    private Integer weight;
    private String referal_details;

    public Integer getPatient_pid() {
        return patient_pid;
    }

    public void setPatient_pid(Integer patient_pid) {
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
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
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
}
