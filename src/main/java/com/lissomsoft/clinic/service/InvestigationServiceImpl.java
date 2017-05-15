package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.InvestigationDaoImpl;

import com.lissomsoft.clinic.domain.Investigation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lissomsoft on 05/15/17.
 */
public class InvestigationServiceImpl implements InvestigationService {


    @Autowired(required = true)
    private InvestigationDaoImpl investigationDao;


    @Override
    public boolean addInvestigation(Investigation investigation) {
        return investigationDao.addInvestigation(investigation);
    }
}
