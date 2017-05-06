package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 05/06/17.
 */
public class Service {

    private Integer service_id;
    private String service_name;
    private Integer charges;
    private String description;

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String toString(){
        return "Service {"+
                ", service_id   ="+service_id+
                ", service_name ="+service_name+
                ", description  ="+description+
                ", charges      ="+charges+
                '}';
    }
}
