package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.ComplaintDao;
import com.lissomsoft.clinic.dao.ComplaintDaoImpl;
import com.lissomsoft.clinic.domain.Complaint;
import com.lissomsoft.clinic.vo.PatientComplaint;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin on 4/17/2017.
 */
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired(required = true)
    private ComplaintDaoImpl complaintDao;


    @Override
    public boolean addcomplaint(Complaint complaint) {
        return complaintDao.addcomplaint(complaint);
    }

    @Override
    public List<Complaint> ViewComplaint() {
        return complaintDao.ViewComplaint();
    }



    @Override
    public Complaint ComplaintDetail(Integer complaint_id) {
        return complaintDao.ComplaintDetail(complaint_id);
    }

    @Override
    public boolean editcomplaint(Complaint complaint, Integer complaint_id) {
        return complaintDao.editcomplaint(complaint,complaint_id);
    }

    @Override
    public PatientComplaint patientcomplaint(String patient_pid) {
        return complaintDao.patientcomplaint(patient_pid);
    }
}
