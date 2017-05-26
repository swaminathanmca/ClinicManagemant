package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Laboratory;
import com.lissomsoft.clinic.rowmapper.LaboratoryMapper;
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
 * Created by Lissomsoft on 05/24/17.
 */
public class LaboratoryDaoImpl implements LaboratoryDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean addLaboratory(Laboratory laboratory) {

        int result=0;

        try {

            String insertLabSql="INSERT INTO laboratory_test_master(test_type,test_name,description,created_at,updated_at) VALUES(:test_type,:test_name,:description,:created_at,:created_at)";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("test_type",laboratory.getTest_type());
            parameter.put("test_name",laboratory.getTest_name());
            parameter.put("description",laboratory.getDescription());
            parameter.put("created_at",format.format(new Date()));
            result=jdbcTemplate.update(insertLabSql,parameter);



        }catch (Exception e){
            e.printStackTrace();
        }


        return result >0 ?true:false;
    }

    @Override
    public List<Laboratory> getLaboratory() {

        List<Laboratory> laboratories=null;
        try{

            String getLabSql="SELECT * FROM laboratory_test_master";
            Map<String,Object> getparams=new HashMap<String, Object>();
            laboratories=jdbcTemplate.query(getLabSql,getparams,new LaboratoryMapper());

        }catch (Exception e){
            e.printStackTrace();
        }

        return laboratories;
    }

    @Override
    public Laboratory getLaboratoryId(Integer test_id) {

        Laboratory laboratory=new Laboratory();
        try {

            String getLabIdSql="SELECT * FROM laboratory_test_master WHERE test_id=:test_id";

            Map<String,Object> getparams=new HashMap<String, Object>();
            getparams.put("test_id",test_id);
            laboratory= (Laboratory) jdbcTemplate.queryForObject(getLabIdSql, getparams, new LaboratoryMapper());

        }catch (Exception e){
            e.printStackTrace();
        }
        return laboratory;
    }

    @Override
    public boolean editLaboratory(Laboratory laboratory) {

        int result=0;

        try {
            String editLabSql="UPDATE laboratory_test_master SET test_name=:test_name,test_type=:test_type,description=:description,updated_at=:updated_at WHERE test_id=:test_id";
            Map<String ,Object> paramater=new HashMap<String, Object>();
            paramater.put("test_id",laboratory.getTest_id());
            paramater.put("test_name",laboratory.getTest_name());
            paramater.put("test_type",laboratory.getTest_type());
            paramater.put("description",laboratory.getDescription());
            paramater.put("updated_at",format.format(new Date()));
            result=jdbcTemplate.update(editLabSql,paramater);

        }catch (Exception e){
            e.printStackTrace();
        }



        return result>0?true:false;
    }

    @Override
    public List<Laboratory> getLaboratoryType(String test_type) {
        List<Laboratory> laboratories=null;
        try {

            String labTypeSql="SELECT * FROM laboratory_test_master WHERE test_type=:test_type";
            Map<String,Object> params=new HashMap<String, Object>();
            params.put("test_type",test_type);
            laboratories=jdbcTemplate.query(labTypeSql,params,new LaboratoryMapper());

        }catch (Exception e){
            e.printStackTrace();
        }
        return laboratories;
    }
}
