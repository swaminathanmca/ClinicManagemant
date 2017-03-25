package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Patient;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public class PatientDaoImpl implements  PatientDao {


    @Override
    public boolean addPatient(Patient patient,Integer clinic_id) {

        int result=0;
       /* try{

            String insertPateientSql="";

        }catch (Exception e){
            e.printStackTrace();
        }*/
        System.out.println(patient+","+clinic_id);

        return result >0 ? true :false;
    }
}
