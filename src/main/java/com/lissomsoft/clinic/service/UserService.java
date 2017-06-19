package com.lissomsoft.clinic.service;
import com.lissomsoft.clinic.domain.User;

import java.util.List;

/**
 * Created by Admin on 2/17/2017.
 */
public interface UserService {
  public List<User> authenticateUser(String email_id,String password);
  Boolean getPassword(String email_id);
  List<User> validateEmail(String email_id);
  Boolean resetPassword(String token,String password);
  List<User> validateToken(String token);

}
