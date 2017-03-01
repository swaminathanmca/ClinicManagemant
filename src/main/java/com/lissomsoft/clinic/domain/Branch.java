package com.lissomsoft.clinic.domain;

/**
 * Created by Admin on 2/28/2017.
 */
public class Branch {

    private Integer branch_id;

    private String branch_name;
    private Integer clinic_id;
    private Integer ho;
    private Integer chief_id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private Integer pin_code;
    private String contact_no;
    private String email;
    private String status;
    private String descripton;
    private String created_at;
    private String updated_at;
    private String created_by;
    private String updated_by;


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

    public Integer getHo() {
        return ho;
    }

    public void setHo(Integer ho) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
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

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }


    public String toString(){
        return "Branch{" +
                "branch_id="+branch_id+
                ", branch_name="+branch_name+
                ", clinic_id="+clinic_id+
                ", chief_id="+chief_id+
                ", address1="+address1+
                ", address2="+address2+
                ", city="+city+
                ", state="+state+
                ", country="+country+
                ", pincode="+pin_code+
                ", contact_no="+contact_no+
                ", email="+email+
                ", status="+status+
                ", description="+descripton+
                ", created_at="+created_at+
                ", updated_at="+updated_at+

                '}';
    }
}
