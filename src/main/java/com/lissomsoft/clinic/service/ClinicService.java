package com.lissomsoft.clinic.service;


import com.lissomsoft.clinic.domain.Branch;
import com.lissomsoft.clinic.domain.Clinic;
import com.lissomsoft.clinic.vo.ClinicUser;

import java.util.List;

/**
 * Created by Admin on 2/20/2017.
 */
public interface ClinicService {

   boolean addClinic(ClinicUser clinic);
   List<Branch> validateno(String contact_no);
   List<Clinic> validateName(String clinic_name);
   List<ClinicUser> clinicDetails(Integer clinic_id);
   List<Branch> email(String email_id);
   List<ClinicUser> getClinic();
  /* List<Clinic> getClinicById(Integer id);*/
   boolean editClinic(ClinicUser clinicUser);
   boolean deleteclinic(Integer clinicID);
    List<ClinicUser> track_id(String email);
}
