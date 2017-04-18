package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.ComplaintDaoImpl;
import com.lissomsoft.clinic.domain.Complaint;

import java.util.List;

/**
 * Created by Admin on 4/17/2017.
 */
public interface ComplaintService {
    boolean addcomplaint(Complaint complaint);
    List<Complaint> ViewComplaint();
    Complaint ComplaintDetail(Integer complaint_id);
    boolean editcomplaint(Complaint complaint,Integer complaint_id);

}
