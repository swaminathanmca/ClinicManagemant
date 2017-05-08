package com.lissomsoft.clinic.domain;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.List;

/**
 * Created by Lissomsoft on 05/04/17.
 */
public class Prescription {

    private Integer prescription_id;
    private String patient_info_id;
    private List<Prescripe> prescriptions;
    private Integer medicine_id;
    private Integer total_quantity;
    private Integer mrg_qty;
    private Integer aft_qty;
    private Integer nig_qty;
    private Integer days;
    private Integer frequency;
    private String medicine_name;
    private Integer mg;

    public Integer getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(Integer prescription_id) {
        this.prescription_id = prescription_id;
    }

    public String getPatient_info_id() {
        return patient_info_id;
    }

    public void setPatient_info_id(String patient_info_id) {
        this.patient_info_id = patient_info_id;
    }

    public Integer getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(Integer medicine_id) {
        this.medicine_id = medicine_id;
    }

    public Integer getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(Integer total_quantity) {
        this.total_quantity = total_quantity;
    }

    public Integer getMrg_qty() {
        return mrg_qty;
    }

    public void setMrg_qty(Integer mrg_qty) {
        this.mrg_qty = mrg_qty;
    }

    public Integer getAft_qty() {
        return aft_qty;
    }

    public void setAft_qty(Integer aft_qty) {
        this.aft_qty = aft_qty;
    }

    public Integer getNig_qty() {
        return nig_qty;
    }

    public void setNig_qty(Integer nig_qty) {
        this.nig_qty = nig_qty;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }


    public List<Prescripe> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescripe> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public Integer getMg() {
        return mg;
    }

    public void setMg(Integer mg) {
        this.mg = mg;
    }

    public String toString(){

        return "Prescription {"+
                " prescription_id ="+prescription_id+
                " patient_info_id ="+patient_info_id+
                " medicine_id ="+medicine_id+
                " prescriptions ="+prescriptions+
                " total_quantity ="+total_quantity+
                " medicine_name ="+medicine_name+
                " mg            ="+mg+
                " mrg_qty ="+mrg_qty+
                " aft_qty ="+aft_qty+
                " nig_qty ="+nig_qty+
                " days ="+days+
                " frequency ="+frequency+
                '}';
    }
}
