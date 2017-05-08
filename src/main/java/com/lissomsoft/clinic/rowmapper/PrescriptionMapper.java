package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Prescription;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/08/17.
 */
public class PrescriptionMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Prescription prescription=new Prescription();
        prescription.setMedicine_id(resultSet.getInt("medicine_id"));
        prescription.setMedicine_name(resultSet.getString("medicine_name"));
        prescription.setPrescription_id(resultSet.getInt("prescription_id"));
        prescription.setPatient_info_id(resultSet.getString("patient_info_id"));
        prescription.setFrequency(resultSet.getInt("fasting"));
        prescription.setDays(resultSet.getInt("no_of_days"));
        prescription.setMrg_qty(resultSet.getInt("mrg_qty"));
        prescription.setAft_qty(resultSet.getInt("aft_qty"));
        prescription.setNig_qty(resultSet.getInt("nig_qty"));
        prescription.setMg(resultSet.getInt("mg"));


        return prescription;
    }
}
