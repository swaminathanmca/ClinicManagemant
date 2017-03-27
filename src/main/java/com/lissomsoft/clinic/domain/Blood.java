package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 3/27/2017.
 */
public class Blood {

    private Integer blood_id;
    private String blood_type;
    private String description;

    public Integer getBlood_id() {
        return blood_id;
    }

    public void setBlood_id(Integer blood_id) {
        this.blood_id = blood_id;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return "Blood{"+
                " blood_id="+blood_id+
                " blood_type="+blood_type+
                '}';
    }
}
