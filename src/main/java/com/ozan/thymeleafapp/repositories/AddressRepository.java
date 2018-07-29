package com.ozan.thymeleafapp.repositories;

import com.ozan.thymeleafapp.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
}
