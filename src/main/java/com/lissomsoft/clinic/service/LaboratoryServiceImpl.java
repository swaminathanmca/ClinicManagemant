package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.LaboratoryDaoImpl;
import com.lissomsoft.clinic.domain.Laboratory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lissomsoft on 05/24/17.
 */
public class LaboratoryServiceImpl implements LaboratoryService {
    @Autowired(required = true)
    private LaboratoryDaoImpl laboratoryDao;
    

    @Override
    public boolean addLaboratory(Laboratory laboratory) {
        return laboratoryDao.addLaboratory(laboratory);
    }

    @Override
    public List<Laboratory> getLaboratory() {
        return laboratoryDao.getLaboratory();
    }
}
