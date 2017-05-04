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
            String insertMedicineSql="INSERT INTO medicine_master  (medicine_name,type,mg,vendor,created_at,updated_at) VALUES(:medicine_name,:type,:mg,:vendor,:created_at,:created_at);";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("medicine_name",medicine.getMedicine_name());
            parameter.put("mg",medicine.getMg());
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

    @Override
    public Medicine medicineDetails(Integer medicine_id) {

        Medicine medicine=new Medicine();
        try {
            String getMedicineSql="SELECT * FROM medicine_master WHERE medicine_id=:medicine_id ";
            Map<String,Object> params=new HashMap<String, Object>();
            params.put("medicine_id",medicine_id);
            medicine= (Medicine) jdbcTemplate.queryForObject(getMedicineSql,params,new MedicineMapper());
        }catch (Exception e){
            e.printStackTrace();
        }




        return medicine;
    }

    @Override
    public boolean editMedicine(Medicine medicine) {

        int result=0;
        try {

            String editMedicineSql="UPDATE medicine_master SET medicine_name=:medicine_name,mg=:mg,vendor=:vendor,type=:type,updated_at=:created_at WHERE medicine_id=:medicine_id";
            Map<String,Object> params1=new HashMap<String, Object>();
            params1.put("medicine_id",medicine.getMedicine_id());
            params1.put("medicine_name",medicine.getMedicine_name());
            params1.put("mg",medicine.getMg());
            params1.put("vendor",medicine.getVendor());
            params1.put("type",medicine.getType());
            params1.put("created_at",format.format(new Date()));
            result=jdbcTemplate.update(editMedicineSql,params1);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result >0 ? true :false;
    }

    @Override
    public List<Medicine> getMedicineType(Integer type) {
        List<Medicine> medicines=null;
        try {

            String medicinesSql="SELECT medicine_id,concat(medicine_name,' ',mg) as medicine_name,mg,type,vendor FROM clinic.medicine_master WHERE medicine_master.type=:mtype";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("mtype",type);
            medicines=jdbcTemplate.query(medicinesSql,parameter,new MedicineMapper());


        }catch (Exception e){
            e.printStackTrace();
        }



        return medicines;
    }
}
