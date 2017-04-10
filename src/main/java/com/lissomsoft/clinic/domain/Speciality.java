package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 08-Apr-17.
 */
public class Speciality {

    private Integer speciallity_id;
    private String speciality_name;
    private String description;

    public Integer getSpeciallity_id() {
        return speciallity_id;
    }

    public void setSpeciallity_id(Integer speciallity_id) {
        this.speciallity_id = speciallity_id;
    }

    public String getSpeciality_name() {
        return speciality_name;
    }

    public void setSpeciality_name(String speciality_name) {
        this.speciality_name = speciality_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return "Speciality {"+
                "speciallity_id="+speciallity_id+
                ",speciality_name="+speciality_name+
                ", description ="+description+
                '}';
    }
}
