package com.scm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Entities.UserDetail;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserDetail,Long>{
    public UserDetail findByEmail(String email);
}
