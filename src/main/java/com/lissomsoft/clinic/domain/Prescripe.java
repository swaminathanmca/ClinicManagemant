package com.lissomsoft.clinic.domain;

import java.util.List;

/**
 * Created by Lissomsoft on 05/05/17.
 */

public class Prescripe {

    private List<Prescription> prescriptions;

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }


    public String toString(){
        return "Prescription {"+
                "prescriptions ="+prescriptions+
                '}';
    }
}
