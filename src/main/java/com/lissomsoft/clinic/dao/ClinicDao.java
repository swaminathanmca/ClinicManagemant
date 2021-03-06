package com.lissomsoft.clinic.dao;
import com.lissomsoft.clinic.domain.Branch;
import com.lissomsoft.clinic.domain.Clinic;
import com.lissomsoft.clinic.vo.ClinicUser;

import java.util.List;

/**
 * Created by Admin on 2/20/2017.
 */
public interface ClinicDao {
    boolean addClinic(ClinicUser clinic);
    boolean editClinic(ClinicUser clinicUser);
    boolean deleteClinic(Integer clinicID);
    List<Branch> validateno(String contact_no);
    List<Clinic> validateName(String clinic_name);
    List<Branch> email(String email_id);
    List<ClinicUser> getClinic();
 /*   List<Clinic> getClinicById(Integer id);*/
    List<ClinicUser> viewDetails(Integer clinic_id);
    List<ClinicUser> track_id(String email);
}
