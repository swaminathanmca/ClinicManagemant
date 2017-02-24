package com.lissomsoft.clinic.dao;
import com.lissomsoft.clinic.domain.Clinic;
import com.lissomsoft.clinic.rowmapper.ClinicMapper;
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
 * Created by Admin on 2/20/2017.
 */
public class ClinicDaoImpl implements ClinicDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public boolean addClinic(Clinic clinic) {
        int result = 0;
        try {
            System.out.println("Number"+clinic.getContact_no());
            String insertBranchSql = "INSERT INTO clinic (clinic_name,address,city,state,zip,contact_number,email,description,created_at,updated_at) VALUES (:clinic_name,:address,:city,:state,:pincode,:contact_number,:email,:description,:created_at,:updated_at)";

            System.out.println(insertBranchSql);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_name", clinic.getClinic_name());
            parameters.put("address", clinic.getAddress());
            parameters.put("city", clinic.getCity());
            parameters.put("state", clinic.getState());
            parameters.put("pincode", clinic.getPincode());
            parameters.put("contact_number", clinic.getContact_no());
            parameters.put("email", clinic.getEmail_id());
            parameters.put("description", clinic.getDescription());
            parameters.put("created_at", format.format(new Date()));
            parameters.put("updated_at", format.format(new Date()));

            result = jdbcTemplate.update(insertBranchSql, parameters);
        } catch (Exception e) {

            e.printStackTrace();
        }


        return (result > 0) ? true : false;
    }

    @Override
    public boolean editClinic(Clinic clinic) {
        int result = 0;

        try {

            String editBranchSql = "UPDATE clinic SET  clinic_name=:clinic_name,address=:address,city=:city,state=:state,zip=:pincode,contact_number=:contact_number,email=:email,description=:description,updated_at=:updated_at WHERE clinic_id=:clinic_id";
            System.out.println(editBranchSql);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_id",clinic.getClinic_id());
            parameters.put("clinic_name", clinic.getClinic_name());
            parameters.put("address", clinic.getAddress());
            parameters.put("city", clinic.getCity());
            parameters.put("state", clinic.getState());
            parameters.put("pincode", clinic.getPincode());
            parameters.put("contact_number", clinic.getContact_no());
            parameters.put("email", clinic.getEmail_id());
            parameters.put("description", clinic.getDescription());
            parameters.put("updated_at", format.format(new Date()));

            result = jdbcTemplate.update(editBranchSql, parameters);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return (result > 0) ? true : false;
    }

    @Override
    public boolean deleteClinic(Integer clinicID) {
        int result=0;
        try {
            String deleteClinic="DELETE FROM clinic WHERE clinic_id=:clinic_id";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_id", clinicID);
            result=jdbcTemplate.update(deleteClinic,parameters);

        }catch (Exception e){
            e.printStackTrace();
        }
        return (result > 0) ? true : false;
    }

    @Override
    public List<Clinic> validateno(String contact_no) {

        Clinic clinicDetails = null;
        List<Clinic> clinciList = null;

        try {
            String validateno = "SELECT * FROM clinic WHERE contact_number=:contact_no";

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("contact_no", contact_no);


            clinciList = jdbcTemplate.query(validateno, parameters, new ClinicMapper());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clinciList;
    }

    @Override
    public List<Clinic> email(String email_id) {
        List<Clinic> clinciListEmail = null;

        try {
            String validateemail = "SELECT * FROM clinic WHERE email=:email_id";
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("email_id", email_id);

            clinciListEmail = jdbcTemplate.query(validateemail, parameter, new ClinicMapper());


        } catch (Exception e) {
            e.printStackTrace();
        }

        return clinciListEmail;
    }

    @Override
    public List<Clinic> getClinic() {
        List<Clinic> getClinicDetails=null;
        try {
            String clinicDetails="SELECT * FROM clinic";
            getClinicDetails=jdbcTemplate.query(clinicDetails, new ClinicMapper());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getClinicDetails;
    }

    @Override
    public List<Clinic> getClinicById(Integer id) {
        List<Clinic> getClinicId=null;
        try {
            String clinicDetails="SELECT * FROM clinic where clinic_id=:clinicId";
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("clinicId", id);
            getClinicId=jdbcTemplate.query(clinicDetails,parameter, new ClinicMapper());
        }catch (Exception e){
            e.printStackTrace();
        }

        return getClinicId;
    }
}