package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Patient;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public class PatientDaoImpl implements  PatientDao {


    @Override
    public boolean addPatient(Patient patient,String email) {

        int result=0;
        try{

            String insertPateientSql="";

        }catch (Exception e){
            e.printStackTrace();
        }

        return result >0 ? true :false;
    }
}
