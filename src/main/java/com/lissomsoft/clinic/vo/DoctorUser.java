package com.lissomsoft.clinic.vo;

import com.lissomsoft.clinic.domain.Branch;
import com.lissomsoft.clinic.domain.Speciality;

import java.util.List;

/**
 * Created by Lissomsoft on 3/20/2017.
 */
public class DoctorUser {

    private  int doctor_id;
    private int user_id;
    private int member_id;
    private int profile_id;
    private int clinic_id;
    private int branch_id;
    private List<Branch> branch;
    private List<Speciality> specialization;
    private String firstname;
    private String reg_no;
    private String qualification;
    /*private String specialization;*/
    private int gender;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String clinic_name;
    private String branch_name;
    private String email_id;
    private String contact_no;
    private String password;
    private Integer charge;
    private Integer roomno;


    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public int getClinic_id() {
        return clinic_id;
    }

    public void setClinic_id(int clinic_id) {
        this.clinic_id = clinic_id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }


    public List<Branch> getBranch() {
        return branch;
    }

    public void setBranch(List<Branch> branch) {
        this.branch = branch;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

 /*   public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }*/

    public List<Speciality> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<Speciality> specialization) {
        this.specialization = specialization;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Integer getRoomno() {
        return roomno;
    }

    public void setRoomno(Integer roomno) {
        this.roomno = roomno;
    }

    public String toString(){
        return "Doctor{"+
                "doctor_id="+doctor_id+
                ", user_id="+user_id+
                ", member_id="+member_id+
                ", profile_id="+profile_id+
                ", clinic_id="+clinic_id+
                ", branch_id="+branch_id+
                ", branch="+branch+
                ", firstname="+firstname+
                ", reg_no="+reg_no+
                ", qualification="+qualification+
                ", specialization="+specialization+
                ", gender="+gender+
                ", address1="+address1+
                ", address2="+address2+
                ", city="+city+
                ", state="+state+
                ", country="+country+
                ", pincode="+pincode+
                ", clinic_name="+clinic_name+
                ", branch_name="+branch_name+
                ", email_id="+email_id+
                ", contact_no="+contact_no+
                ", password="+password+
                ", charge="    +charge+
                ", roomno="+roomno+
                '}';
    }
}
