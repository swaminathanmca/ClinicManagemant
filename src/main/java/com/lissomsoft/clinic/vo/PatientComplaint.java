package com.lissomsoft.clinic.vo;

/**
 * Created by Admin on 4/18/2017.
 */
public class PatientComplaint {

    private Integer patient_pid;
    private Integer patient_id;
    private String first_name;
    private String last_name;
    private Integer weight;
    private Integer height;
    private Integer pressure;
    private String complaint_name;


    public Integer getPatient_pid() {
        return patient_pid;
    }

    public void setPatient_pid(Integer patient_pid) {
        this.patient_pid = patient_pid;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public String getComplaint_name() {
        return complaint_name;
    }

    public void setComplaint_name(String complaint_name) {
        this.complaint_name = complaint_name;
    }



    public String toString(){

        return "PatientComplaint =" +
                "patient_pid ="+ patient_pid +
                "patient_id ="+ patient_id +
                "first_name ="+ first_name +
                "last_name ="+ last_name +
                "weight ="+ weight +
                "height ="+ height +
                "pressure ="+ pressure +
                "complaint_name ="+ complaint_name +
                "}";



    }
}
