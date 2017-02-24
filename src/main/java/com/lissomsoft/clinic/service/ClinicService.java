package com.lissomsoft.clinic.service;


import com.lissomsoft.clinic.domain.Clinic;

import java.util.List;

/**
 * Created by Admin on 2/20/2017.
 */
public interface ClinicService {

   boolean addClinic(Clinic clinic);
   List<Clinic> validateno(String contact_no);
   List<Clinic> email(String email_id);
   List<Clinic> getClinic();
   List<Clinic> getClinicById(Integer id);
   boolean editClinic(Clinic clinic);
   boolean deleteclinic(Integer clinicID);
}
