package com.lissomsoft.clinic.service;
import com.lissomsoft.clinic.domain.User;

import java.util.List;

/**
 * Created by Admin on 2/17/2017.
 */
public interface UserService {
  public List<User> authenticateUser(String username,String password);

}
