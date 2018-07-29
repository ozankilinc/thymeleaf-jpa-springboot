package com.ozan.thymeleafapp.controller;

import com.ozan.thymeleafapp.entity.Address;
import com.ozan.thymeleafapp.entity.Employee;
import com.ozan.thymeleafapp.service.AddressService;
import com.ozan.thymeleafapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class EmployeeController {
    private ArrayList<Employee> employeeArrayList=null;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message",message);
        return "index";
    }
    @RequestMapping(value = {"/employees"},method = RequestMethod.GET)
    public String getEmployees(Model model){
        employeeArrayList=employeeService.getAllEmployee();
        model.addAttribute("employees",employeeArrayList);
        return "employees";
    }

    @RequestMapping(value = {"/addEmployee"},method = RequestMethod.POST)
    public String addEmployee(Model model, @ModelAttribute("employee")Employee employee){

        String name=employee.getName();
        String surname=employee.getSurname();
        String city = employee.getAddress().getCity();
        String avenue=employee.getAddress().getAvenue();
        if(name!=null && surname!=null && city!=null && avenue!=null){
            Address newAdres=new Address(city,avenue);
            Employee newEmployee=new Employee(name,surname,newAdres);
            newAdres.setEmployee(newEmployee);
            employeeService.addEmployee(newEmployee);
           addressService.addAddress(newAdres);
            return "redirect:/employees";
        }
        model.addAttribute("errorMessage",errorMessage);
        return "addEmployee";

    }
    @RequestMapping(value = {"/addEmployee"},method = RequestMethod.GET)
    public String showAddEmployeePage(Model model){
        Employee employee=new Employee();
        Address address=new Address();
        model.addAttribute("employee",employee);
        model.addAttribute("address",address);
        return "addEmployee";
    }
}
