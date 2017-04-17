package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.ComplaintDao;
import com.lissomsoft.clinic.domain.Complaint;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Admin on 4/17/2017.
 */
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired(required = true)
    private ComplaintDao complaintDao;


    @Override
    public boolean addcomplaint(Complaint complaint) {
        return complaintDao.addcomplaint(complaint);
    }
}
