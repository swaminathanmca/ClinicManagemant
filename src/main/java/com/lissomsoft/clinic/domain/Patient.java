package com.lissomsoft.clinic.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Admin on 2/14/2017.
 */
@XmlRootElement
public class Patient {


    private int patientId;

    private String fullName;

    private String gender;

    private String bloodGroup;

    private String mStatus;

    private String dob;

    private String status;

    private String factor;

    @XmlAttribute
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    @Override
 public String toString(){

        return  "Patient{" +

                "patientId="+patientId+
                ",fullName='"+fullName+ '\'' +
                ",gender='"+gender+ '\'' +
                ",bloodGroup='"+bloodGroup+ '\'' +
                ",mStatus='"+mStatus+ '\'' +
                ", dob='" + dob + '\'' +
                ",status='"+status+ '\'' +
                ",factor='"+factor+ '\'' +
                '}';

 }

}
