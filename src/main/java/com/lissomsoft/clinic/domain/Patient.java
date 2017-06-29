package com.lissomsoft.clinic.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Admin on 2/14/2017.
 */
@XmlRootElement
public class Patient {

    private int patientId;

    private String fullName;

    private String lastName;

    private String patient_pId;

    private Integer gender;

    private String mStatus;

    private Integer bloodGroup;

    private Integer factor;

    private String dob;

    private String status;

    private String email;

    private String contact_no;

    private String residental_no;

    private String address1;

    private String address2;

    private  String city;

    private String state;

    private String country;

    private String pincode;

    private String emergency_name;

    private String relation;

    private String emergency_address1;

    private String emergency_address2;

    private String emergency_city;

    private String emergency_state;

    private String emergency_country;

    private String emergency_pincode;

    private String emergency_contact_no;

    private String emergency_residental_no;

    private String emergency_email;

    private String referred_by;

    private String allergy_food;

    private String allergy_others;




    @XmlAttribute
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(Integer bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getResidental_no() {
        return residental_no;
    }

    public void setResidental_no(String residental_no) {
        this.residental_no = residental_no;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmergency_name() {
        return emergency_name;
    }

    public void setEmergency_name(String emergency_name) {
        this.emergency_name = emergency_name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getEmergency_address1() {
        return emergency_address1;
    }

    public void setEmergency_address1(String emergency_address1) {
        this.emergency_address1 = emergency_address1;
    }

    public String getEmergency_address2() {
        return emergency_address2;
    }

    public void setEmergency_address2(String emergency_address2) {
        this.emergency_address2 = emergency_address2;
    }

    public String getEmergency_city() {
        return emergency_city;
    }

    public void setEmergency_city(String emergency_city) {
        this.emergency_city = emergency_city;
    }

    public String getEmergency_state() {
        return emergency_state;
    }

    public void setEmergency_state(String emergency_state) {
        this.emergency_state = emergency_state;
    }

    public String getEmergency_country() {
        return emergency_country;
    }

    public void setEmergency_country(String emergency_country) {
        this.emergency_country = emergency_country;
    }

    public String getEmergency_pincode() {
        return emergency_pincode;
    }

    public void setEmergency_pincode(String emergency_pincode) {
        this.emergency_pincode = emergency_pincode;
    }

    public String getEmergency_contact_no() {
        return emergency_contact_no;
    }

    public void setEmergency_contact_no(String emergency_contact_no) {
        this.emergency_contact_no = emergency_contact_no;
    }

    public String getEmergency_residental_no() {
        return emergency_residental_no;
    }

    public void setEmergency_residental_no(String emergency_residental_no) {
        this.emergency_residental_no = emergency_residental_no;
    }

    public String getEmergency_email() {
        return emergency_email;
    }

    public void setEmergency_email(String emergency_email) {
        this.emergency_email = emergency_email;
    }


    public String getPatient_pId() {
        return patient_pId;
    }

    public void setPatient_pId(String patient_pId) {
        this.patient_pId = patient_pId;
    }

    public String getReferred_by() {
        return referred_by;
    }

    public void setReferred_by(String referred_by) {
        this.referred_by = referred_by;
    }

    public String getAllergy_food() {
        return allergy_food;
    }

    public void setAllergy_food(String allergy_food) {
        this.allergy_food = allergy_food;
    }

    public String getAllergy_others() {
        return allergy_others;
    }

    public void setAllergy_others(String allergy_others) {
        this.allergy_others = allergy_others;
    }

    @Override
 public String toString(){

        return  "Patient{" +

                "patientId="+patientId+
                ",fullName='"+fullName+ '\'' +
                ",lastName='"+lastName+'\''+
                ",patient_pId='"+patient_pId+'\''+
                ",gender='"+gender+ '\'' +
                ",mStatus='"+mStatus+ '\'' +
                ",bloodGroup='"+bloodGroup+ '\'' +
                ",factor='"+factor+ '\'' +
                ", dob='" + dob + '\'' +
                ",status='"+status+ '\'' +
                ",email='"+email+ '\'' +
                ",contact_no='"+contact_no+ '\'' +
                ",residental_no='"+residental_no+ '\'' +
                ",address1='"+address1+ '\'' +
                ",address2='"+address2+ '\'' +
                ",city='"+city+ '\'' +
                ",state='"+state+ '\'' +
                ",country='"+country+ '\'' +
                ",pincode='"+pincode+ '\'' +
                ",emergency_name='"+emergency_name+ '\'' +
                ",relation='"+relation+ '\'' +
                ",emergency_address1='"+emergency_address1+ '\'' +
                ",emergency_address2='"+emergency_address2+ '\'' +
                ",emergency_city='"+emergency_city+ '\'' +
                ",emergency_state='"+emergency_state+ '\'' +
                ",emergency_country='"+emergency_country+ '\'' +
                ",emergency_pincode='"+emergency_pincode+ '\'' +
                ",emergency_contact_no='"+emergency_contact_no+ '\'' +
                ",emergency_residental_no='"+emergency_residental_no+ '\'' +
                ",emergency_email='"+emergency_email+'\'' +
                ",referred_by="+referred_by+
                ",allergy_food="+allergy_food+
                ",allergy_others="+allergy_others+
                '}';

 }

}
