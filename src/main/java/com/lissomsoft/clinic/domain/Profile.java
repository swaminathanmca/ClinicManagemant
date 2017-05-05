package com.lissomsoft.clinic.domain;

/**
 * Created by Admin on 3/1/2017.
 */
public class Profile {

    private Integer profile_id;

    private String name;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private  String country;

    private String contact_no;

    private String email;

    private Integer pin_code;

    private Integer gender;

    private String created_at;

    private String updated_at;


    public Integer getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPin_code() {
        return pin_code;
    }

    public void setPin_code(Integer pin_code) {
        this.pin_code = pin_code;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String toString(){
        return  "Profile{"+
                "  profile_id ="+ profile_id +
                ", name ="+ name +
                ", address1 ="+ address1 +
                ", address2 ="+ address2 +
                ", city ="+ city +
                ", state ="+ state +
                ", country ="+ country +
                ", contact_no ="+ contact_no +
                ", email ="+ email +
                ", pin_code ="+ pin_code +
                ", gender="+gender+
                ", created_at="+created_at+
                ", updated_at="+updated_at+
                '}';
    }

}
