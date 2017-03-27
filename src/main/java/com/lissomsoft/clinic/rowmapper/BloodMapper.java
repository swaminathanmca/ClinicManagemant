package com.lissomsoft.clinic.rowmapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.lissomsoft.clinic.domain.Blood;
/**
 * Created by Lissomsoft on 3/27/2017.
 */
public class BloodMapper  implements RowMapper<Blood>{

    @Override
    public Blood mapRow(ResultSet resultSet, int i) throws SQLException {
        Blood blood=new Blood();


        blood.setBlood_id(resultSet.getInt("blood_id"));
        blood.setBlood_type(resultSet.getString("blood_group"));
        return blood;
    }
}
