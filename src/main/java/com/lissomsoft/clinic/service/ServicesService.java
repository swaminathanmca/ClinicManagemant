package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Service;

import java.util.List;

/**
 * Created by Lissomsoft on 05/06/17.
 */
public interface ServicesService {
    boolean addService(Service service,Integer branch_id);
    List<Service> getServices(Integer branch_id);
    boolean editService(Service service,Integer branch_id);
    Service serviceDetails(Integer service_id);
}
