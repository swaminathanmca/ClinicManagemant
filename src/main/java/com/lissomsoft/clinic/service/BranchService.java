package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Branch;
import com.lissomsoft.clinic.vo.ClinicUser;

import java.util.List;

/**
 * Created by Lissomsoft on 3/15/2017.
 */
public interface BranchService {

    boolean addBranch(ClinicUser branch);

    List<Branch>  getBranch(Integer clinic_id);

}
