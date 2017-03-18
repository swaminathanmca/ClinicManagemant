package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Branch;
import com.lissomsoft.clinic.domain.Clinic;
import com.lissomsoft.clinic.vo.ClinicUser;

import java.util.List;

/**
 * Created by Lissomsoft on 3/15/2017.
 */
public interface BranchDao {

    boolean addBranch(ClinicUser branch);
    List<Branch> getBranch(Integer clinic_id);
    List<ClinicUser> getDetails(Integer branch_id);
    boolean editBranch(ClinicUser clinicUser);
}
