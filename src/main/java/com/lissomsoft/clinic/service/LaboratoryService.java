package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.LaboratoryDaoImpl;
import com.lissomsoft.clinic.domain.Laboratory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lissomsoft on 05/24/17.
 */
public interface LaboratoryService {

    boolean addLaboratory(Laboratory laboratory);
    List<Laboratory> getLaboratory();
    Laboratory getLaboratoryId(Integer test_id);
    boolean editLaboratory(Laboratory laboratory);
    List<Laboratory> getLaboratoryType(String test_type);
    Laboratory getLabType(String test_name);
    List<Laboratory> TypeLab();
}
