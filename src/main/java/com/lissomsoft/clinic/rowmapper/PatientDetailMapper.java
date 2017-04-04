package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 4/3/2017.
 */
public class PatientDetailMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Patient patient=new Patient();
        patient.setFullName(resultSet.getString("first_name"));
        patient.setLastName(resultSet.getString("last_name"));
        patient.setAddress1(resultSet.getString("address1"));
        patient.setAddress2(resultSet.getString("address2"));
        patient.setCity(resultSet.getString("city"));
        patient.setState(resultSet.getString("state"));
        patient.setCountry(resultSet.getString("country"));
        patient.setPincode(resultSet.getString("pincode"));
        patient.setContact_no(resultSet.getString("contact_no"));
        patient.setResidental_no(resultSet.getString("mobile_no"));
        patient.setEmail(resultSet.getString("email_id"));
        patient.setGender(resultSet.getInt("sex"));
        patient.setDob(resultSet.getString("dob"));
        patient.setBloodGroup(resultSet.getString("blood_group_code"));
        patient.setmStatus(resultSet.getString("mstatus"));
        patient.setPatient_pId(resultSet.getString("patient_pid"));
        patient.setEmergency_name(resultSet.getString("name"));
        patient.setRelation(resultSet.getString("relation"));
        patient.setEmergency_address1(resultSet.getString("emr_address1"));
        patient.setEmergency_address2(resultSet.getString("emr_address2"));
        patient.setEmergency_city(resultSet.getString("emr_city"));
        patient.setEmergency_state(resultSet.getString("emr_state"));
        patient.setEmergency_country(resultSet.getString("emr_country"));
        patient.setEmergency_pincode(resultSet.getString("emr_pincode"));
        patient.setEmergency_contact_no(resultSet.getString("emr_contact_no"));
        patient.setEmergency_residental_no(resultSet.getString("emr_mobile_no"));
        patient.setEmergency_email(resultSet.getString("emr_email_id"));

        return patient;
    }
}
