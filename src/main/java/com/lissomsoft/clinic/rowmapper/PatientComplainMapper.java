package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.vo.PatientComplaint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PatientComplainMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {

        PatientComplaint patientcomplaint=new PatientComplaint();
        patientcomplaint.setPatient_pid(rs.getString("patient_pid"));
        patientcomplaint.setPatient_id(rs.getInt("patient_id"));
        patientcomplaint.setFirst_name(rs.getString("first_name"));
        patientcomplaint.setLast_name(rs.getString("last_name"));
        patientcomplaint.setDob(rs.getString("dob"));
        patientcomplaint.setGender(rs.getString("sex"));
        patientcomplaint.setWeight(rs.getInt("weight"));
        patientcomplaint.setType(rs.getInt("type"));
        patientcomplaint.setPressure(rs.getInt("pressure"));
        patientcomplaint.setHeight(rs.getInt("height"));
        patientcomplaint.setComplaint_name(rs.getString("refereal_details"));
        patientcomplaint.setCreated_at(rs.getString("created_at"));
        patientcomplaint.setDoctor_detail_id(rs.getInt("doctor_detail_id"));






        return patientcomplaint;
    }

}
