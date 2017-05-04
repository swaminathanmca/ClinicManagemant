package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 04/27/17.
 */
public class Medicine {

    private Integer medicine_id;
    private String medicine_name;
    private Integer mg;
    private Integer type;
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

    public String getMedicine_name() {
        return medicine_name;
    }

    public Integer getMg() {
        return mg;
    }

    public void setMg(Integer mg) {
        this.mg = mg;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String toString(){

        return "Medicine{"+
                " medicine_id="+medicine_id+
                " medicine_name="+medicine_name+
                " mg="+ mg +

                " type="+type+
                " vendor="+vendor+ '}';
    }
}
