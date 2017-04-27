package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 04/27/17.
 */
public class Medicine {

    private Integer medicine_id;
    private String medicine_name;
    private String mfg_date;
    private String exp_date;
    private String vendor;
    private String updated_at;
    private String created_at;

    public Integer getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(Integer medicine_id) {
        this.medicine_id = medicine_id;
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public String getMfg_date() {
        return mfg_date;
    }

    public void setMfg_date(String mfg_date) {
        this.mfg_date = mfg_date;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }


    public String toString(){

        return "Medicine{"+
                " medicine_id="+medicine_id+
                " medicine_name="+medicine_name+
                " mfg_date="+mfg_date+
                " exp_date="+exp_date+
                " vendor="+vendor+ '}';
    }
}
