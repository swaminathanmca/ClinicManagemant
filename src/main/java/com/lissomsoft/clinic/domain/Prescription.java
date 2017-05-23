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
    private String remarks;
    private Integer type;
    private Integer days1;
    private Integer days2;
    private Integer days3;
    private Integer days4;
    private Integer days5;
    private Integer days6;
    private Integer days7;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDays1() {
        return days1;
    }

    public void setDays1(Integer days1) {
        this.days1 = days1;
    }

    public Integer getDays2() {
        return days2;
    }

    public void setDays2(Integer days2) {
        this.days2 = days2;
    }

    public Integer getDays3() {
        return days3;
    }

    public void setDays3(Integer days3) {
        this.days3 = days3;
    }

    public Integer getDays4() {
        return days4;
    }

    public void setDays4(Integer days4) {
        this.days4 = days4;
    }

    public Integer getDays5() {
        return days5;
    }

    public void setDays5(Integer days5) {
        this.days5 = days5;
    }

    public Integer getDays6() {
        return days6;
    }

    public void setDays6(Integer days6) {
        this.days6 = days6;
    }

    public Integer getDays7() {
        return days7;
    }

    public void setDays7(Integer days7) {
        this.days7 = days7;
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
                " type ="+type+
                " remarks="+remarks+
                " days1="+days1+
                " days2="+days2+
                "days3 ="+days3+
                "days4 ="+days4+
                "days5 ="+days5+
                "days6 ="+days6+
                "days7 ="+days6+
                '}';
    }
}
