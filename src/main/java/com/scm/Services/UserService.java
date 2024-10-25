package com.scm.Services;

 
import com.scm.Entities.UserDetail;

import java.util.*;

public interface UserService {

    UserDetail saveuser(UserDetail user);
    Optional<UserDetail> getUserById(Long id);
    UserDetail updateUser(UserDetail user) throws Exception;
    void deleteUser(Long id);
    Boolean isExistUser(Long id);
    Boolean isUserExistByEmail(String email);
    List<UserDetail> getAllUser();    

}
