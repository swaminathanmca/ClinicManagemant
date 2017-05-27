package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.LabInvestigation;

import java.util.List;

/**
 * Created by Lissomsoft on 05/26/17.
 */
public interface LabInvestigationService {

    Boolean addLabInvestigation(LabInvestigation labInvestigation);
    List<LabInvestigation> getInvestigation(Integer patient_info_id);
    Boolean removeLabInvestigation(Integer investigation_id);
}
