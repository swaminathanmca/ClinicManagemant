package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Complaint;

import java.util.List;

/**
 * Created by Admin on 4/17/2017.
 */
public interface ComplaintDao {
    boolean addcomplaint(Complaint complaint);


    List<Complaint> ViewComplaint();

    Complaint ComplaintDetail (Integer complaint_id);
    boolean editcomplaint(Complaint complaint,Integer complaint_id);
}
