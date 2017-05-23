package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Doctor;
import com.lissomsoft.clinic.domain.Profile;
import com.lissomsoft.clinic.vo.DoctorUser;

import java.util.List;

/**
 * Created by Lissomsoft on 3/20/2017.
 */
public interface DoctorDao {
    boolean addDoctor(DoctorUser doctorUser);
    List<Profile> viewDoctor(String branch_id);
    List<Profile> viewAllDoctor(String clinic_id);
    DoctorUser doctorDetails(Integer profile_id);
    boolean editDoctor(DoctorUser doctorUser);
    boolean addFrontdesk(DoctorUser frontdesk);
    List<Profile> viewFrontDesk(String branch_id);
    List<Profile> viewFrontDeskAll(Integer clinic_id);
    List<Doctor> trackSeason(String email);
    DoctorUser frontdeskDetails(Integer profile_id);
    List<DoctorUser> doctorspecailities(String speciallity_id,String branch_id);
    List<DoctorUser> getDoctor(String branch_id);
    DoctorUser getDoctorCharges(Integer doctor_id);
    DoctorUser getDoctorProfile(Integer doctor_id);
}
