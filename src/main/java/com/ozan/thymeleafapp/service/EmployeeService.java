package com.ozan.thymeleafapp.service;

import com.ozan.thymeleafapp.entity.Address;
import com.ozan.thymeleafapp.entity.Employee;
import com.ozan.thymeleafapp.repositories.AddressRepository;
import com.ozan.thymeleafapp.repositories.EmployeeRepository;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
//@ComponentScan(basePackages = {"com.ozan.thymeleafapp.repositories"})
public class EmployeeService {

    @Autowired
    private  EmployeeRepository employeeRepository;

    public ArrayList<Employee> getAllEmployee(){
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeByName(String name){
        return employeeRepository.getEmployeeByName(name);
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }



    public void deleteEmployeeByName(String name){
        employeeRepository.deleteByName(name);
    }

}

