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
   List<Branch> email(String email_id);
   List<Clinic> getClinic();
   List<Clinic> getClinicById(Integer id);
   boolean editClinic(Clinic clinic);
   boolean deleteclinic(Integer clinicID);
}
