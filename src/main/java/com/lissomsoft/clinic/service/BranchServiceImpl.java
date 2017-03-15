package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.vo.ClinicUser;
import com.lissomsoft.clinic.dao.BranchDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lissomsoft on 3/15/2017.
 */
public class BranchServiceImpl implements BranchService {
    @Autowired(required = true)
    private BranchDao branchDao;


    @Override
    public boolean addBranch(ClinicUser branch) {
        return branchDao.addBranch(branch);
    }
}
