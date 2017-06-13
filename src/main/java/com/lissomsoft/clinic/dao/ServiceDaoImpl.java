package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Service;
import com.lissomsoft.clinic.rowmapper.ServiceMapper;
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
 * Created by Lissomsoft on 05/06/17.
 */
public class ServiceDaoImpl implements  ServiceDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public boolean addService(Service service,Integer branch_id) {

        int result=0;
     try{

    String insertServiceSql="INSERT INTO services (service_name,description,charges,branch_id,created_at,updated_at) VALUES (:service_name,:description,:charges,:branch_id,:created_at,:created_at)";
    Map<String,Object> parameter=new HashMap<String, Object>();
    parameter.put("service_name",service.getService_name());
    parameter.put("description",service.getDescription());
    parameter.put("charges",service.getCharges());
         parameter.put("branch_id",branch_id);
    parameter.put("created_at",format.format(new Date()));
    result=jdbcTemplate.update(insertServiceSql,parameter);

    }
     catch (Exception e){
        e.printStackTrace();

    }





        return result >0 ? true :false;
    }

    @Override
    public List<Service> getServices(Integer branch_id) {

       List<Service> services=null;
       try {
           String selectServiceSql="SELECT * FROM services WHERE branch_id=:branch_id";
           Map<String,Object> params=new HashMap<String, Object>();
           params.put("branch_id",branch_id);
            services=jdbcTemplate.query(selectServiceSql,params,new ServiceMapper());


       }catch (Exception e){
           e.printStackTrace();
       }



        return services;
    }

    @Override
    public boolean editService(Service service,Integer branch_id) {

        int result=0;
        try {

            String editServiceSql="UPDATE services SET service_name=:service_name,description=:description,charges=:charges,updated_at=:created_at WHERE service_id=:service_id ";
            Map<String,Object> paramsserives=new HashMap<String, Object>();
            paramsserives.put("service_id",service.getService_id());
            paramsserives.put("service_name",service.getService_name());
            paramsserives.put("charges",service.getCharges());
            paramsserives.put("description",service.getDescription());
            paramsserives.put("branch_id",branch_id);
            paramsserives.put("created_at",format.format(new Date()));
            result=jdbcTemplate.update(editServiceSql,paramsserives);

        }catch (Exception e){
            e.printStackTrace();
        }


        return result >0 ?true:false;
    }

    @Override
    public Service serviceDetails(Integer service_id) {

        Service service=new Service();
        try {
            String selectServiceSql="SELECT * FROM services WHERE service_id=:service_id";
            Map<String,Object> servicedet=new HashMap<String, Object>();
            servicedet.put("service_id",service_id);
            service= (Service) jdbcTemplate.queryForObject(selectServiceSql, servicedet, new ServiceMapper());
        }catch (Exception e){
            e.printStackTrace();
        }
        return service;
    }
}
