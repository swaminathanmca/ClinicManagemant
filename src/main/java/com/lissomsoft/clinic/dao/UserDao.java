package com.lissomsoft.clinic.dao;
import com.lissomsoft.clinic.domain.*;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Admin on 2/17/2017.
 */
public interface UserDao {

    List<User> authenticateUser(String email_id,String password);
    Boolean getPassword(String email_id) throws MessagingException;
    List<User> validateEmail(String email_id);
    Boolean resetPassword(String token,String password);
    List<User> validateToken(String  token);
}
