package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Laboratory;

import java.util.List;

/**
 * Created by Lissomsoft on 05/24/17.
 */
public interface LaboratoryDao {
    boolean addLaboratory(Laboratory laboratory);
    List<Laboratory> getLaboratory();
}
