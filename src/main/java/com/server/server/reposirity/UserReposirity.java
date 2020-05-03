package com.server.server.reposirity;

import com.server.server.entity.OrderUser;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface UserReposirity extends JpaRepository<OrderUser,Integer> {
    public List<OrderUser> findByIDs(String ID);
}
