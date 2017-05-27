package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 05/26/17.
 */
public class LabInvestigation {


    private Integer labinvestigation_id;

    private Integer patient_info_id;

    private String test_type;

    private String test_name;

    private String remarks;


    public Integer getLabinvestigation_id() {
        return labinvestigation_id;
    }

    public void setLabinvestigation_id(Integer labinvestigation_id) {
        this.labinvestigation_id = labinvestigation_id;
    }

    public Integer getPatient_info_id() {
        return patient_info_id;
    }

    public void setPatient_info_id(Integer patient_info_id) {
        this.patient_info_id = patient_info_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTest_type() {
        return test_type;
    }

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public String toString(){

        return "LabInvestigation{"+
                " labinvestigation_id="+labinvestigation_id+
                " patient_info_id="+patient_info_id+
                " test_name="+test_name+
                " test_type ="+test_type+
                " remarks="+remarks+
                '}';
    }
}
