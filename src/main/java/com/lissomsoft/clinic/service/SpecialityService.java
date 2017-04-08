package com.lissomsoft.clinic.service;


import com.lissomsoft.clinic.domain.Speciality;

import java.util.List;


/**
 * Created by Lissomsoft on 08-Apr-17.
 */
public interface SpecialityService {

    boolean addSpeciality(Speciality speciality );

    List<Speciality> viewSpeciality();

    Speciality specialityDetails(Integer speciality_id);

    boolean editSpeciality(Speciality speciality,Integer speciality_id);
}
