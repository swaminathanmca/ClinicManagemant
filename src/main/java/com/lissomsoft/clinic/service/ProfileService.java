package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Profile;

import java.util.List;

/**
 * Created by Admin on 3/1/2017.
 */
public interface ProfileService {
    List<Profile> validateno(String contact_no);
    List<Profile> validateEmail(String email);
}
