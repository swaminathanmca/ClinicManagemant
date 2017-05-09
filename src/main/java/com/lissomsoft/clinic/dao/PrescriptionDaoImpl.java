package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Prescripe;
import com.lissomsoft.clinic.domain.Prescription;
import com.lissomsoft.clinic.rowmapper.PrescriptionMapper;
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

                String insertPrescriptionSql="INSERT INTO prescription_master (patient_info_id,medicine_id,medicine_name,mg,mrg_qty,aft_qty,nig_qty,type,no_of_days,fasting,created_at) VALUES (:patient_info_id,:medicine_id,:medicine_name,:mg,:mrg_qty,:aft_qty,:nig_qty,:type,:days,:frequency,:created_at)";
                Map<String,Object> parameter=new HashMap<String, Object>();
                parameter.put("patient_info_id",pr.getPatient_info_id());
                parameter.put("medicine_id",pr.getMedicine_id());
                parameter.put("days",pr.getDays());
                parameter.put("mrg_qty",pr.getMrg_qty());
                parameter.put("aft_qty",pr.getAft_qty());
                parameter.put("nig_qty",pr.getNig_qty());
                parameter.put("type",pr.getType());
                parameter.put("frequency",pr.getFrequency());
                parameter.put("medicine_name",pr.getMedicine_name());
                parameter.put("mg",pr.getMg());
                parameter.put("created_at",format.format(new Date()));
                result=jdbcTemplate.update(insertPrescriptionSql,parameter);

            }


        }catch (Exception e){
            e.printStackTrace();
        }


        return result > 0 ? true : false;
    }

    @Override
    public List<Prescription> getPrescription(Integer patient_info_id) {

        List<Prescription> prescriptions=null;

        try {

            String getPrescription="SELECT * FROM clinic.prescription_master WHERE patient_info_id=:patient_info_id";
            Map<String,Object> params=new HashMap<String, Object>();
            params.put("patient_info_id",patient_info_id);

            prescriptions=jdbcTemplate.query(getPrescription,params,new PrescriptionMapper());


        }catch (Exception e){
            e.printStackTrace();
        }

        return prescriptions;
    }

    @Override
    public boolean removeprescription(Prescripe prescripe) {

        int result=0;
        try {
            List<Prescription> prescripes;
            prescripes = prescripe.getPrescriptions();
            Iterator<Prescription> it = prescripes.iterator();
            while (it.hasNext()) {
                Prescription pr = it.next();
                String removePresSql="DELETE FROM prescription_master WHERE prescription_id=:prescription_id";
                Map<String,Object> paramsprescription=new HashMap<String, Object>();
                paramsprescription.put("prescription_id",pr.getPrescription_id());
                result=jdbcTemplate.update(removePresSql,paramsprescription);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result >0 ? true:false;
    }

    @Override
    public boolean editPrescription(Prescription prescription) {

        int result=0;
        try
        {

            String editprescriptionSql="UPDATE prescription_master SET medicine_id=:medicine_id,medicine_name=:medicine_name,mg=:mg,mrg_qty=:mrg_qty,aft_qty=:aft_qty,nig_qty=:nig_qty,no_of_days=:days,fasting=:frequency,type=:types WHERE prescription_id=:prescription_id";
            Map<String,Object> paramsprescription=new HashMap<String, Object>();
            paramsprescription.put("prescription_id",prescription.getPrescription_id());
            paramsprescription.put("medicine_id",prescription.getMedicine_id());
            paramsprescription.put("medicine_name",prescription.getMedicine_name());
            paramsprescription.put("mg",prescription.getMg());
            paramsprescription.put("mrg_qty",prescription.getMrg_qty());
            paramsprescription.put("aft_qty",prescription.getAft_qty());
            paramsprescription.put("nig_qty",prescription.getNig_qty());
            paramsprescription.put("days",prescription.getDays());
            paramsprescription.put("frequency",prescription.getFrequency());
            paramsprescription.put("types",prescription.getType());
            result=jdbcTemplate.update(editprescriptionSql,paramsprescription);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return result >0 ?true:false;
    }

    @Override
    public Prescription getPrescriptionById(Integer prescription_id) {

        Prescription prescription=new Prescription();
        try {

            String getPrescriptionSql="SELECT * FROM  prescription_master WHERE  prescription_id=:prescription_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("prescription_id",prescription_id);
            prescription= (Prescription) jdbcTemplate.queryForObject(getPrescriptionSql, parameter, new PrescriptionMapper());


        }catch (Exception e){
            e.printStackTrace();
        }


        return prescription;
    }


}
