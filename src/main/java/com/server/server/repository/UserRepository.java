package com.server.server.repository;

import com.server.server.entity.User;
import org.springframework.data.jpa.repository.*;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findUserByUserIDAndAndUserPwd(String userID, String userPwd);

    public List<User> findUserByUserID(String userID);
}
