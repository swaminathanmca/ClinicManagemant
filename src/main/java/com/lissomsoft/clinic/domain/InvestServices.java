package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 05/15/17.
 */
public class InvestServices {

    private Integer investigation_id;
    private String service_name;
    private Integer discount;
    private Integer charges;


    public Integer getInvestigation_id() {
        return investigation_id;
    }

    public void setInvestigation_id(Integer investigation_id) {
        this.investigation_id = investigation_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getCharges() {
        return charges;
    }

    public void setCharges(Integer charges) {
        this.charges = charges;
    }

    public String toString(){
        return "InvestService { "+
                ", investigation_id="+investigation_id+
                ", service_name    ="+service_name+
                ", discount        ="+discount+
                ", charges         ="+charges+
                '}';
    }
}
