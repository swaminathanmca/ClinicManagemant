package com.lissomsoft.clinic.vo;

/**
 * Created by Admin on 2/28/2017.
 */
public class ClinicUser {

    private String clinic_name;

    private String register_no;

    private String status;

    private  String chief_name;

    private Integer branch_id;

    private String branch_name;

    private Integer clinic_id;

    private String ho;

    private Integer chief_id;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String country;

    private Integer pin_code;

    private String contact_no;

    private String email_id;

    private String password;

    private String chief_address1;

    private String chief_address2;

    private String chief_state;

    private String chief_country;

    private String chief_city;

    private String chief_contact_no;

    private String chief_email_id;

    private String chief_pin_code;

    private String gender;

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public String getRegister_no() {
        return register_no;
    }

    public void setRegister_no(String register_no) {
        this.register_no = register_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChief_name() {
        return chief_name;
    }

    public void setChief_name(String chief_name) {
        this.chief_name = chief_name;
    }

    public Integer getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Integer branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public Integer getClinic_id() {
        return clinic_id;
    }

    public void setClinic_id(Integer clinic_id) {
        this.clinic_id = clinic_id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public Integer getChief_id() {
        return chief_id;
    }

    public void setChief_id(Integer chief_id) {
        this.chief_id = chief_id;
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

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChief_address1() {
        return chief_address1;
    }

    public void setChief_address1(String chief_address1) {
        this.chief_address1 = chief_address1;
    }

    public String getChief_address2() {
        return chief_address2;
    }

    public void setChief_address2(String chief_address2) {
        this.chief_address2 = chief_address2;
    }

    public String getChief_state() {
        return chief_state;
    }

    public void setChief_state(String chief_state) {
        this.chief_state = chief_state;
    }

    public String getChief_country() {
        return chief_country;
    }

    public void setChief_country(String chief_country) {
        this.chief_country = chief_country;
    }

    public String getChief_city() {
        return chief_city;
    }

    public void setChief_city(String chief_city) {
        this.chief_city = chief_city;
    }

    public String getChief_contact_no() {
        return chief_contact_no;
    }

    public void setChief_contact_no(String chief_contact_no) {
        this.chief_contact_no = chief_contact_no;
    }

    public String getChief_email_id() {
        return chief_email_id;
    }

    public void setChief_email_id(String chief_email_id) {
        this.chief_email_id = chief_email_id;
    }

    public String getChief_pin_code() {
        return chief_pin_code;
    }

    public void setChief_pin_code(String chief_pin_code) {
        this.chief_pin_code = chief_pin_code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString(){

        return "ClinicUser{"+
                "clinic_id="+ clinic_id +
                "clinic_name="+clinic_name+
                "register_no="+register_no+
                "status="+status+
                "chief_name="+chief_name+
                "branch_id="+branch_id+
                "branch_name="+branch_name+
                "ho="+ho+
                "chief_id="+chief_id+
                "address1="+address1+
                "address2="+address2+
                "city="+city+
                "state="+state+
                "country="+country+
                "pin_code="+pin_code+
                "contact_no="+contact_no+
                "email_id="+email_id+
                "password="+password+
                "chief_address1="+chief_address1+
                "chief_address2="+chief_address2+
                "chief_city="+chief_city+
                "chief_state="+chief_state+
                "chief_country="+chief_country+
                "chief_contact_no="+chief_contact_no+
                "chief_email_id="+chief_email_id+
                "chief_pin_code="+chief_pin_code+
                "gender="+gender+
                '}';
    }
}
