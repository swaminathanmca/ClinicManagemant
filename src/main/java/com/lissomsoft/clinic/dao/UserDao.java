package com.lissomsoft.clinic.dao;
import com.lissomsoft.clinic.domain.*;

import java.util.List;

/**
 * Created by Admin on 2/17/2017.
 */
public interface UserDao {

    List<User> authenticateUser(String username,String password);
}
