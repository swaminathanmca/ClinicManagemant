package com.lissomsoft.clinic.domain;

/**
 * Created by Admin on 2/20/2017.
 */
public class Clinic {



    private  int clinic_id;

    private String clinic_name;

    private String register_no;

    private String status;

    private String chief;

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

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
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

        return  "Clinic{"+
                "clinic_id="+ clinic_id +
                ",clinic_name="+ clinic_name +
                ",register_no="+register_no+
                ",status="+status+
                ",chief="+chief+
                ",created_at="+created_at+
                ",updated_at="+updated_at+
                '}';
    }


}
