package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.ProfileDaoImpl;
import com.lissomsoft.clinic.dao.ServiceDaoImpl;
import com.lissomsoft.clinic.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lissomsoft on 05/06/17.
 */
public class ServicesServiceImpl implements ServicesService {

    @Autowired(required = true)
    private ServiceDaoImpl serviceDao;

    @Override
    public boolean addService(Service service) {
        return serviceDao.addService(service);
    }

    @Override
    public List<Service> getServices() {
        return serviceDao.getServices();
    }

    @Override
    public boolean editService(Service service) {
        return serviceDao.editService(service);
    }

}
