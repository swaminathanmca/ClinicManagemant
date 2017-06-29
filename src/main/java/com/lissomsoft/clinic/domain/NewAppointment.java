package com.lissomsoft.clinic.domain;

/**
 * Created by Admin on 6/27/2017.
 */
public class NewAppointment {

    private Integer new_appointment_id;
    private String new_appointment_pid;
    private Integer branch_id;
    private String first_name;
    private String last_name;
    private Integer doctor_id;
    private String dob;
    private String mobile_no;
    private String res_no;
    private String email;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private Integer pin_code;

    public Integer getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Integer branch_id) {
        this.branch_id = branch_id;
    }

    public String getNew_appointment_pid() {
        return new_appointment_pid;
    }

    public void setNew_appointment_pid(String new_appointment_pid) {
        this.new_appointment_pid = new_appointment_pid;
    }

    public Integer getNew_appointment_id() {
        return new_appointment_id;
    }

    public void setNew_appointment_id(Integer new_appointment_id) {
        this.new_appointment_id = new_appointment_id;
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

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getRes_no() {
        return res_no;
    }

    public void setRes_no(String res_no) {
        this.res_no = res_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPin_code() {
        return pin_code;
    }

    public void setPin_code(Integer pin_code) {
        this.pin_code = pin_code;
    }

    public String toString(){
        return "New_appointment {" +
                "new_appointment_id = "+ new_appointment_id +
                "new_appointment_pid = "+ new_appointment_pid +
                "branch_id = "+ branch_id +
                "first_name = "+ first_name +
                "last_name = "+ last_name +
                "doctor_id = "+ doctor_id +
                "dob = "+ dob +
                "mobile_no = "+ mobile_no +
                "res_no = "+ res_no +
                "email = "+ email +
                "address1 = "+ address1 +
                "address2 = "+ address2 +
                "city = "+ city +
                "state = "+ state +
                "country = "+ country +
                "pin_code = "+ pin_code +
                "}";
    }


}
