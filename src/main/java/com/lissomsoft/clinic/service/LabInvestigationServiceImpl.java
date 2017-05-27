package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.LabInvestigationDaoImpl;
import com.lissomsoft.clinic.domain.LabInvestigation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lissomsoft on 05/26/17.
 */
public class LabInvestigationServiceImpl implements LabInvestigationService {
    @Autowired(required = true)
    private LabInvestigationDaoImpl labInvestigationDao;


    @Override
    public Boolean addLabInvestigation(LabInvestigation labInvestigation) {
        return labInvestigationDao.addLabInvestigation(labInvestigation);
    }

    @Override
    public List<LabInvestigation> getInvestigation(Integer patient_info_id) {
        return labInvestigationDao.getInvestigation(patient_info_id);
    }

    @Override
    public Boolean removeLabInvestigation(Integer investigation_id) {
        return labInvestigationDao.removeLabInvestigation(investigation_id);
    }

    @Override
    public LabInvestigation getLabInvestigation(Integer investigation_id) {
        return labInvestigationDao.getLabInvestigation(investigation_id);
    }

    @Override
    public Boolean editlabInvestigation(LabInvestigation labInvestigation) {
        return labInvestigationDao.editlabInvestigation(labInvestigation);
    }
}
