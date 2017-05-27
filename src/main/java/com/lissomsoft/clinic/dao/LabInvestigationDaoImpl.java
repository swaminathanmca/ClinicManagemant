package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.LabInvestigation;
import com.lissomsoft.clinic.domain.Laboratory;
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
import com.lissomsoft.clinic.rowmapper.LabInvestigationMapper;

/**
 * Created by Lissomsoft on 05/26/17.
 */
public class LabInvestigationDaoImpl implements LabInvestigationDao{
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public Boolean addLabInvestigation(LabInvestigation labInvestigation) {

        int result=0;
        try{
            String insertInvesSql="INSERT INTO lab_investigation (patient_info_id,test_type,test_name,remarks,created_at,updated_at) VALUES (:patient_info_id,:test_type,:test_name,:remarks,:created_at,:created_at)";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_info_id",labInvestigation.getPatient_info_id());
            parameter.put("test_type",labInvestigation.getTest_type());
            parameter.put("test_name",labInvestigation.getTest_name());
            parameter.put("remarks",labInvestigation.getRemarks());
            parameter.put("created_at",format.format(new Date()));
            result=jdbcTemplate.update(insertInvesSql,parameter);


        }catch (Exception e){
            e.printStackTrace();
        }
        return result>0?true:false;
    }

    @Override
    public List<LabInvestigation> getInvestigation(Integer patient_info_id) {
        List<LabInvestigation> labInvestigations=null;
        try {

            String getLabSql="SELECT * FROM lab_investigation WHERE patient_info_id=:patient_info_id";
            Map<String,Object> paramater=new HashMap<String, Object>();
            paramater.put("patient_info_id",patient_info_id);
            labInvestigations=jdbcTemplate.query(getLabSql, paramater, new LabInvestigationMapper());

        }catch (Exception e){
            e.printStackTrace();
        }


        return labInvestigations;
    }

    @Override
    public Boolean removeLabInvestigation(Integer investigation_id) {
        int result=0;
        try {
            String removeSql="DELETE FROM lab_investigation WHERE labinvestigation_id=:labinvestigation_id";
            Map<String,Object> pars=new HashMap<String, Object>();
            pars.put("labinvestigation_id",investigation_id);
            result=jdbcTemplate.update(removeSql,pars);

        }catch (Exception e){
            e.printStackTrace();
        }


        return result>0?true:false;
    }

    @Override
    public LabInvestigation getLabInvestigation(Integer investigation_id) {

        LabInvestigation labInvestigation=new LabInvestigation();
        try {

            String getinvestSql="SELECT * FROM lab_investigation WHERE labinvestigation_id=:investigation_id";
            Map<String,Object> paras=new HashMap<String, Object>();
            paras.put("investigation_id",investigation_id);
            labInvestigation=(LabInvestigation) jdbcTemplate.queryForObject(getinvestSql,paras,new LabInvestigationMapper());


        }catch (Exception e){
            e.printStackTrace();
        }


        return labInvestigation;
    }

    @Override
    public Boolean editlabInvestigation(LabInvestigation labInvestigation) {

        int result=0;
        try {

            String editLabSql="UPDATE lab_investigation SET test_type=:test_type,test_name=:test_name,remarks=:remarks WHERE labinvestigation_id=:id ";
            Map<String,Object> parals=new HashMap<String, Object>();
            parals.put("id",labInvestigation.getLabinvestigation_id());
            parals.put("test_type",labInvestigation.getTest_type());
            parals.put("test_name",labInvestigation.getTest_name());
            parals.put("remarks",labInvestigation.getRemarks());
            result=jdbcTemplate.update(editLabSql,parals);


        }catch (Exception e){
            e.printStackTrace();
        }


        return result>0?true :false;
    }


}
