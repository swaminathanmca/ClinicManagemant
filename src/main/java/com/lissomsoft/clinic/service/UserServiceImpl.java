package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.User;
import com.lissomsoft.clinic.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin on 2/17/2017.
 */
public class UserServiceImpl implements UserService {


    @Autowired(required = true)
    private UserDaoImpl userDao;
    @Override
    public List<User> authenticateUser(String email_id,String password) {

        return userDao.authenticateUser(email_id,password);
    }

    @Override
    public Boolean getPassword(String email_id) {
        return userDao.getPassword(email_id);
    }

    @Override
    public List<User> validateEmail(String email_id) {
        return userDao.validateEmail(email_id);
    }

    @Override
    public Boolean resetPassword(String token, String password) {
        return userDao.resetPassword(token,password);
    }

    @Override
    public List<User> validateToken(String token) {
        return userDao.validateToken(token);
    }
}
