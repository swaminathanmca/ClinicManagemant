package com.lissomsoft.clinic.dao;
import com.lissomsoft.clinic.domain.Clinic;

import java.util.List;

/**
 * Created by Admin on 2/20/2017.
 */
public interface ClinicDao {
    boolean addClinic(Clinic clinic);
    boolean editClinic(Clinic clinic);
    boolean deleteClinic(Integer clinicID);
    List<Clinic> validateno(String contact_no);
    List<Clinic> email(String email_id);
    List<Clinic> getClinic();
    List<Clinic> getClinicById(Integer id);
}
