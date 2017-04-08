package com.lissomsoft.clinic.service;

import java.util.List;

import com.lissomsoft.clinic.dao.SpecialityDao;
import com.lissomsoft.clinic.domain.Speciality;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lissomsoft on 08-Apr-17.
 */
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired(required = true)
    private SpecialityDao specialityDao;

    @Override
    public boolean addSpeciality(Speciality speciality) {
        return specialityDao.addSpeciality(speciality);
    }

    @Override
    public List<Speciality> viewSpeciality() {

        return specialityDao.viewSpeciality();
    }

    @Override
    public Speciality specialityDetails(Integer speciality_id) {
        return specialityDao.specialityDetails(speciality_id);
    }
}
