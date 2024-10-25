package com.scm.ServicesImpl;
import com.scm.Entities.UserDetail;
import com.scm.Repository.UserRepository;
import com.scm.Services.UserService;

import java.util.List;
import java.util.Optional;

import com.scm.helper.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
 
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userrepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetail saveuser(UserDetail user) {
        // user id genraste the dynamic
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleList(List.of(AppConstants.Role_User));
        return userrepo.save(user);
    }

    @Override
    public Optional<UserDetail> getUserById(Long id) {
      return userrepo.findById(id);
    }

    @Override
    public UserDetail updateUser(UserDetail user) throws Exception {
        UserDetail userData = userrepo.findById(user.getId()).orElseThrow(()->new RuntimeException("User Not found"));
        userData.setName(user.getName());
        userData.setEmail(user.getEmail());
        userData.setPhoneNumber(user.getPhoneNumber());
        userData.setAbout(user.getAbout());
        userData.setEnabled(user.getEnabled());
        userData.setProfilePic(user.getProfilePic());
        userData.setEmailverified(user.getEmailverified());
        userData.setPhoneVerified(user.getPhoneVerified());
        userData.setProvider(user.getProvider());
        userData.setProviderId(user.getProviderId());
        UserDetail saveUser = userrepo.save(userData);
        return saveUser;     
    }

    @Override
    public void deleteUser(Long id) {
        UserDetail user1 = userrepo.findById(id).orElseThrow(()->new RuntimeException("This is the wrong user"));
         userrepo.delete(user1);
    }

    @Override
    public Boolean isExistUser(Long id) {
        UserDetail user = userrepo.findById(id).orElse(null);
        return user!=null?true:false;
    }

    @Override
    public Boolean isUserExistByEmail(String email) {
        UserDetail user = userrepo.findByEmail(email);
        return user!=null?true:false;
    }

    @Override
    public List<UserDetail> getAllUser() {
         List<UserDetail> allUserList = userrepo.findAll();
         return allUserList;
    }
}