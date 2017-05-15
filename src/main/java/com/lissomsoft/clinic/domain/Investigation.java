package com.lissomsoft.clinic.domain;

import java.util.List;

/**
 * Created by Lissomsoft on 05/15/17.
 */
public class Investigation {
    private Integer investigation_id;
    private Integer visit_id;
    private String patient_pid;
    private Integer total_amount;
    private String service_name;
    private Integer charges;
    private Integer discount;
    private List<InvestServices> investServices;

    public Integer getInvestigation_id() {
        return investigation_id;
    }

    public void setInvestigation_id(Integer investigation_id) {
        this.investigation_id = investigation_id;
    }

    public Integer getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    public String getPatient_pid() {
        return patient_pid;
    }

    public void setPatient_pid(String patient_pid) {
        this.patient_pid = patient_pid;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Integer getCharges() {
        return charges;
    }

    public void setCharges(Integer charges) {
        this.charges = charges;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public List<InvestServices> getInvestServices() {
        return investServices;
    }

    public void setInvestServices(List<InvestServices> investServices) {
        this.investServices = investServices;
    }

    public String toString(){
        return "Investigation {" +
                ", investiagation_id ="+investigation_id+
                ", visit_id  ="+visit_id+
                ", patient_pid ="+patient_pid+
                ", total_amount ="+total_amount+
                ", service_name ="+service_name+
                ", charges ="+charges+
                ", discount ="+discount+
                ", investServices ="+investServices+
                '}';
    }

}
