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
    public boolean addService(Service service,Integer branch_id) {
        return serviceDao.addService(service,branch_id);
    }

    @Override
    public List<Service> getServices(Integer branch_id) {
        return serviceDao.getServices(branch_id);
    }

    @Override
    public boolean editService(Service service,Integer branch_id) {
        return serviceDao.editService(service,branch_id);
    }

    @Override
    public Service serviceDetails(Integer service_id) {
        return serviceDao.serviceDetails(service_id);
    }

}
