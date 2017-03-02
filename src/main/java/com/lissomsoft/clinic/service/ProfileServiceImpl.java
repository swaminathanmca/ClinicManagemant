package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.ProfileDao;
import com.lissomsoft.clinic.dao.ProfileDaoImpl;
import com.lissomsoft.clinic.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin on 3/1/2017.
 */
public class ProfileServiceImpl implements ProfileService {

    @Autowired(required = true)
    private ProfileDaoImpl profileDao;

    public List<Profile> validateno(String contact_no) {
        return profileDao.validateno(contact_no);
    }

    @Override
    public List<Profile> validateEmail(String email) {
        return profileDao.validateEmail(email);
    }
}
