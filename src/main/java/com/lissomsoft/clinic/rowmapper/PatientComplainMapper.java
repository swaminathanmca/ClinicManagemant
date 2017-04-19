package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.vo.PatientComplaint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PatientComplainMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {

        PatientComplaint patientcomplaint=new PatientComplaint();
        patientcomplaint.setPatient_id(rs.getInt("patient_id"));
        patientcomplaint.setFirst_name(rs.getString("first_name"));
        patientcomplaint.setLast_name(rs.getString("last_name"));
        patientcomplaint.setWeight(rs.getInt("weight"));
        patientcomplaint.setHeight(rs.getInt("height"));
        patientcomplaint.setPressure(rs.getInt("pressure"));
        patientcomplaint.setComplaint_name(rs.getString("refereal_details"));




        return patientcomplaint;
    }

}
