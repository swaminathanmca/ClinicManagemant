package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Service;

import java.util.List;

/**
 * Created by Lissomsoft on 05/06/17.
 */
public interface ServiceDao {

    boolean addService(Service service);
    List<Service> getServices();
    boolean editService(Service service);
}
