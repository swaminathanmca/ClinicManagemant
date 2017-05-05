package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Prescripe;
import com.lissomsoft.clinic.domain.Prescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lissomsoft on 05/05/17.
 */
public class PrescriptionDaoImpl implements PrescriptionDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean addPrescription(Prescripe prescriptions) {

        int result=0;
        try {
            List<Prescription> prescripes;
            prescripes=prescriptions.getPrescriptions();
            Iterator<Prescription> it=prescripes.iterator();
            while (it.hasNext()){
                Prescription pr=it.next();

                String insertPrescriptionSql="INSERT INTO prescription_master (patient_info_id,medicine_id,mrg_qty,aft_qty,nig_qty,no_of_days,fasting,created_at) VALUES (:patient_info_id,:medicine_id,:mrg_qty,:aft_qty,:nig_qty,:days,:frequency,:created_at)";
                Map<String,Object> parameter=new HashMap<String, Object>();
                parameter.put("patient_info_id",pr.getPatient_info_id());
                parameter.put("medicine_id",pr.getMedicine_id());
                parameter.put("days",pr.getDays());
                parameter.put("mrg_qty",pr.getMrg_qty());
                parameter.put("aft_qty",pr.getAft_qty());
                parameter.put("nig_qty",pr.getNig_qty());
                parameter.put("frequency",pr.getFrequency());
                parameter.put("created_at",format.format(new Date()));
                result=jdbcTemplate.update(insertPrescriptionSql,parameter);

            }


        }catch (Exception e){
            e.printStackTrace();
        }


        return result > 0 ? true : false;
    }
}
