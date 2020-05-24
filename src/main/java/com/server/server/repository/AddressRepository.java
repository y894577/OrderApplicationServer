package com.server.server.repository;

import com.server.server.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    public List<Address> findAllByUserID(String userID);

    public List<Address> findByUserIDAndIsDefaultTrue(String userID);
}
