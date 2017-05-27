package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.LabInvestigation;

import java.util.List;

/**
 * Created by Lissomsoft on 05/26/17.
 */
public interface LabInvestigationDao {

    Boolean addLabInvestigation(LabInvestigation labInvestigation);
    List<LabInvestigation> getLabInvestigation(Integer patient_info_id);
    Boolean removeLabInvestigation(Integer investigation_id);
}
