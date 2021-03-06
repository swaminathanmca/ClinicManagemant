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

    @Override
    public Laboratory getLaboratoryId(Integer test_id) {
        return laboratoryDao.getLaboratoryId(test_id);
    }

    @Override
    public boolean editLaboratory(Laboratory laboratory) {
        return laboratoryDao.editLaboratory(laboratory);
    }

    @Override
    public List<Laboratory> getLaboratoryType(String test_type) {
        return laboratoryDao.getLaboratoryType(test_type);
    }

    @Override
    public Laboratory getLabType(String test_name) {
        return laboratoryDao.getLabType(test_name);
    }

    @Override
    public List<Laboratory> TypeLab() {
        return laboratoryDao.TypeLab();
    }
}
