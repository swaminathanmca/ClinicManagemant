package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Profile;
import com.lissomsoft.clinic.vo.DoctorUser;

import java.util.List;

/**
 * Created by Lissomsoft on 3/20/2017.
 */
public interface DoctorService {

    boolean addDoctor(DoctorUser doctorUser);

    List<Profile> viewDoctor(Integer branch_id);
    List<DoctorUser> doctorDetails(Integer profile_id);
    boolean editDoctor(DoctorUser doctorUser);
    boolean addFrontdesk(DoctorUser frontdesk);
    List<Profile> viewFrontDesk(Integer branch_id);
}
