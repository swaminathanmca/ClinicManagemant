package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.PatientInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 4/19/2017.
 */
public class PatientInfoDaoImpl implements PatientInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public boolean addpatientinfo(PatientInfo patientInfo) {
        int result=0;
        try{
            String addpatientInfo="insert into patient_info_master(patient_pid,weight,bp,referal_details,complaint_id,procedures) values(:patient_pid,:weight,:bp,:referal_details,:complaint_id,:procedures)";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_pid",patientInfo.getPatient_pid());
            parameter.put("weight",patientInfo.getWeight());
            parameter.put("bp",patientInfo.getPressure());
            parameter.put("referal_details",patientInfo.getRefereal_details());
            parameter.put("complaint_id",patientInfo.getComplaint_id());
            parameter.put("procedures",patientInfo.getProcedures());

            result=jdbcTemplate.update(addpatientInfo,parameter);

        }catch(Exception e){
            e.printStackTrace();
        }

        return result>0 ? true:false;
    }

    @Override
    public List<PatientInfo> addpatientinfo() {
        return null;
    }

    @Override
    public PatientInfo patientInfo(Integer patient_info_id) {
        return null;
    }


}
