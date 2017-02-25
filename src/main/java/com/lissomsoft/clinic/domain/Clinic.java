package com.lissomsoft.clinic.domain;

/**
 * Created by Admin on 2/20/2017.
 */
public class Clinic {



    private  int clinic_id;

    private String clinic_name;

    private String location;
    private String country;

    private String address;

    private String city;

    private  String state;

    private String contact_no;

    private String email_id;

    private int pincode;

    private String description;

    private String created_at;

    private String updated_at;


    public int getClinic_id() {
        return clinic_id;
    }

    public void setClinic_id(int clinic_id) {
        this.clinic_id = clinic_id;
    }

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString(){

        return  "Clinic{"+
                "clinic_id="+ clinic_id +
                ",clinic_name="+ clinic_name +
                ",location="+location+
                ",country="+country+
                ",address="+address +
                ",contact_no="+contact_no+
                ",email_id="+email_id+
                ",city="+city+
                ",state="+state+
                ",pincode="+pincode+
                ",description="+description+
                ",created_at="+created_at+
                ",updated_at="+updated_at+
                '}';
    }


}
