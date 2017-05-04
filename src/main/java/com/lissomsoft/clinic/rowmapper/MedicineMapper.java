package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Medicine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 04/27/17.
 */
public class MedicineMapper implements RowMapper{


    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Medicine medicine=new Medicine();
        medicine.setMedicine_id(rs.getInt("medicine_id"));
        medicine.setMedicine_name(rs.getString("medicine_name"));
        medicine.setMg(rs.getInt("mg"));
        medicine.setType(rs.getInt("type"));
        medicine.setVendor(rs.getString("vendor"));
        return medicine;



    }
}
