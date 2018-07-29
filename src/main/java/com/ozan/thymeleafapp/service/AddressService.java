package com.ozan.thymeleafapp.service;

import com.ozan.thymeleafapp.entity.Address;
import com.ozan.thymeleafapp.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public ArrayList<Address> getAllAddrees(){
        return (ArrayList<Address>) addressRepository.findAll();
    }

    public void addAddress(Address address){
        addressRepository.save(address);
    }

}
