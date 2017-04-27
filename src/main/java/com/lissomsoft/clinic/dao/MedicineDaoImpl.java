package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Medicine;
import com.lissomsoft.clinic.rowmapper.MedicineMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lissomsoft on 04/27/17.
 */
public class MedicineDaoImpl implements MedicineDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public boolean addMedicine(Medicine medicine) {

        int result=0;

        try {
            String insertMedicineSql="INSERT INTO medicine_master  (medicine_name,mfg_date,type,exp_date,vendor,created_at,updated_at) VALUES(:medicine_name,:mfg_date,:type,:exp_date,:vendor,:created_at,:created_at);";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("medicine_name",medicine.getMedicine_name());
            parameter.put("mfg_date",medicine.getMfg_date());
            parameter.put("exp_date",medicine.getExp_date());
            parameter.put("type",medicine.getType());
            parameter.put("vendor",medicine.getVendor());
            parameter.put("created_at",format.format(new Date()));
            result=jdbcTemplate.update(insertMedicineSql,parameter);



        }
        catch (Exception e){
            e.printStackTrace();
        }

        return result >0 ? true :false;
    }

    @Override
    public List<Medicine> getMedicine() {

        List<Medicine> medicines=null;
        try {

            String getMedicineSql="SELECT * FROM medicine_master";
            medicines=jdbcTemplate.query(getMedicineSql,new MedicineMapper());

        }catch (Exception e){
            e.printStackTrace();
        }




        return medicines;
    }
}
