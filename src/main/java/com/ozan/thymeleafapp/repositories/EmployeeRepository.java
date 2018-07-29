package com.ozan.thymeleafapp.repositories;

import com.ozan.thymeleafapp.entity.Address;
import com.ozan.thymeleafapp.entity.Employee;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {



    Employee getEmployeeByName(String name);

    void deleteByName(String name);
}
