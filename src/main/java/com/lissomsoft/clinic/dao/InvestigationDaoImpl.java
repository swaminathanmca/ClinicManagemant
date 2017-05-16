package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.InvestServices;
import com.lissomsoft.clinic.domain.Investigation;
import com.lissomsoft.clinic.rowmapper.InvestigationMapper;
import com.lissomsoft.clinic.rowmapper.InvestigationServiceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lissomsoft on 05/15/17.
 */
public class InvestigationDaoImpl implements InvestigationDao{
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private PlatformTransactionManager platformTransactionManager;


    @Override
    public boolean addInvestigation(Investigation investigation) {
        int result=0;
        int result_user=0;
        int result_service=0;
        int result_update=0;

        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);

        try {

            String insertInvestigation="INSERT INTO investigation_master(visit_id,patient_pid,total_amount,created_at,updated_at) VALUES(:visit_id,:patient_pid,:tot_amt,:created_at,:created_at)";
            Map<String,Object> paramaters=new HashMap<String, Object>();
            paramaters.put("visit_id",investigation.getVisit_id());
            paramaters.put("patient_pid",investigation.getPatient_pid());
            paramaters.put("tot_amt",investigation.getTotal_amount());
            paramaters.put("created_at",format.format(new Date()));
            result_user=jdbcTemplate.update(insertInvestigation,paramaters);
        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }
        if((result_user >0) ? true :false){
            try {

                List<InvestServices> investServices;
                investServices=investigation.getInvestServices();
                Iterator<InvestServices> it=investServices.iterator();
                while (it.hasNext()){
                    InvestServices is=it.next();
                    String insertServices="INSERT INTO investigation_services(investigation_id,service_name,discount,charges,created_at,updated_at) VALUES((SELECT im.investigation_id FROM investigation_master im WHERE visit_id=:visit_id),:service_name,:discount,:charges,:created_at,:created_at)";
                    Map<String,Object> params=new HashMap<String, Object>();
                    params.put("service_name",is.getService_name());
                    params.put("visit_id",investigation.getVisit_id());
                    params.put("charges",is.getCharges());
                    params.put("discount",is.getDiscount());
                    params.put("created_at",format.format(new Date()));
                    result=jdbcTemplate.update(insertServices,params);
                }


            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }

        if((result > 0) ? true:false){
            try {

                String insertinvest="INSERT INTO investigation_services(investigation_id,service_name,discount,charges,created_at,updated_at) VALUES((SELECT im.investigation_id FROM investigation_master im WHERE visit_id=:visit_id),:service_name,:discount,:charges,:created_at,:created_at)";
                Map<String ,Object> serviceparams=new HashMap<String, Object>();
                serviceparams.put("service_name",investigation.getService_name());
                serviceparams.put("visit_id",investigation.getVisit_id());
                serviceparams.put("discount",investigation.getDiscount());
                serviceparams.put("charges",investigation.getCharges());
                serviceparams.put("created_at",format.format(new Date()));
                result_service=jdbcTemplate.update(insertinvest,serviceparams);




            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }



        }

        if((result_service >0) ? true:false){
            try {
                String updateVisit=" UPDATE patient_visit SET status=:status WHERE visit_id=:visit_id";
                Map<String,Object> upparams=new HashMap<String, Object>();
                upparams.put("status",0);
                upparams.put("visit_id",investigation.getVisit_id());
                result_update=jdbcTemplate.update(updateVisit,upparams);
                platformTransactionManager.commit(status);



            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }

        return result_update>0 ?true:false;
    }

    @Override
    public Investigation getCharges(Integer visit_id) {
            Investigation investigation=new Investigation();
            List<InvestServices> investServices=investigation.getInvestServices();

        try {

            String getInvestigationSql="SELECT ins.service_name,ins.charges,ins.discount FROM clinic.investigation_services ins WHERE ins.investigation_id=(select im.investigation_id FROM clinic.investigation_master im WHERE im.visit_id=:visit_id)";
            String getInvesSql="SELECT visit_id,total_amount FROM investigation_master WHERE visit_id=:visit_id";
            Map<String,Object> parameters=new HashMap<String, Object>();
            parameters.put("visit_id",visit_id);
            investServices=jdbcTemplate.query(getInvestigationSql,parameters,new InvestigationServiceMapper());
            investigation= (Investigation) jdbcTemplate.queryForObject(getInvesSql,parameters,new InvestigationMapper());
            investigation.setInvestServices(investServices);


        }catch (Exception e){
            e.printStackTrace();
        }


        return investigation;
    }
}
