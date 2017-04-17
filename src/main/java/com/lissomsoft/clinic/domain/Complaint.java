package com.lissomsoft.clinic.domain;

/**
 * Created by Admin on 4/17/2017.
 */
public class Complaint {

    private Integer complaint_id;
    private String complaint_name;
    private String complaint_description;

    public Integer getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(Integer complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getComplaint_name() {
        return complaint_name;
    }

    public void setComplaint_name(String complaint_name) {
        this.complaint_name = complaint_name;
    }

    public String getComplaint_description() {
        return complaint_description;
    }

    public void setComplaint_description(String complaint_description) {
        this.complaint_description = complaint_description;
    }

    public String toString(){
        return "complaint{"+
                "complaint_id="+complaint_id+
                "complaint_name="+complaint_name+
                "description="+complaint_description+ '}';
    }
}
