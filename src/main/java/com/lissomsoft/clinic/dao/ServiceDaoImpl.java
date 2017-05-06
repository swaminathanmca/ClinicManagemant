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
    public boolean addService(Service service) {

        int result=0;
     try{

    String insertServiceSql="INSERT INTO services (service_name,description,charges,created_at,updated_at) VALUES (:service_name,:description,:charges,:created_at,:created_at)";
    Map<String,Object> parameter=new HashMap<String, Object>();
    parameter.put("service_name",service.getService_name());
    parameter.put("description",service.getDescription());
    parameter.put("charges",service.getCharges());
    parameter.put("created_at",format.format(new Date()));
    result=jdbcTemplate.update(insertServiceSql,parameter);

    }
     catch (Exception e){
        e.printStackTrace();

    }





        return result >0 ? true :false;
    }

    @Override
    public List<Service> getServices() {

       List<Service> services=null;
       try {
           String selectServiceSql="SELECT * FROM services";

            services=jdbcTemplate.query(selectServiceSql,new ServiceMapper());

       }catch (Exception e){
           e.printStackTrace();
       }



        return services;
    }

    @Override
    public boolean editService(Service service) {

        int result=0;
        try {

            String editServiceSql="UPDATE services SET service_name=:service_name,description=:description,created_at=:created_at WHERE service_id=:service_id";
            Map<String,Object> paramsserives=new HashMap<String, Object>();
            paramsserives.put("service_id",service.getService_id());
            paramsserives.put("service_name",service.getService_name());
            paramsserives.put("description",service.getDescription());
            paramsserives.put("created_at",format.format(new Date()));


        }catch (Exception e){
            e.printStackTrace();
        }


        return result >0 ?true:false;
    }
}
