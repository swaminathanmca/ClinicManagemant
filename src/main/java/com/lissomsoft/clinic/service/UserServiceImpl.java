package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.User;
import com.lissomsoft.clinic.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin on 2/17/2017.
 */
public class UserServiceImpl implements UserService {


    @Autowired(required=true)
    private UserDaoImpl userDao;
    @Override
    public List<User> authenticateUser(String username,String password) {

        return userDao.authenticateUser(username,password);
    }
}
