package com.server.server.controller;

import com.server.server.entity.Address;
import com.server.server.entity.Goods;
import com.server.server.repository.AddressRepository;
import com.server.server.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping(value = "/getAddressList")
    public List<Address> getAddressList(@RequestParam("userID") String userID) {
        return addressRepository.findAllByUserID(userID);
    }

    @PostMapping(value = "/addAddress")
    public String addAddress(@RequestParam("userID") String userID, @RequestParam("address") String address) {
        Address item = new Address(userID, address, false);
        addressRepository.save(item);
        return "添加成功！";
    }

    @PostMapping(value = "/getDefaultAddress")
    public String getDefaultAddress(@RequestParam("userID") String userID) {
        Address address = addressRepository.findByUserIDAndIsDefaultTrue(userID).get(0);
        return address.getAddress();
    }
}
