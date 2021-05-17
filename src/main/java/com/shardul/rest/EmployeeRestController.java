package com.shardul.rest;

import java.util.List;

import javax.transaction.Transactional;

import com.shardul.dao.Employeedao;
import com.shardul.entity.Employee;
import com.shardul.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // @Autowired
    // private Employeedao employeedao;
    
    @Autowired
    private EmployeeService employeeService;

    //quick and dirty: inject employee dao
    // @Autowired
    // public EmployeeRestController(Employeedao theEmployeedao){
    //     employeedao = theEmployeedao;
    //     // employeeService = theEmployeedao;
    // }

    //quick and dirty: inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeedao){
        employeeService = theEmployeedao;
    }

    // expose "/employees" and return list of employees      
    @GetMapping("/employees")
    public List<Employee> findAll(){
        // return employeedao.findAll();   
        return employeeService.findAll();   
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee ==null)
        {
            throw new RuntimeException(" EMployee id not found!!"+employeeId);
        }
        return theEmployee;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {

        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return theEmployee;
    }

//If we do POST method from client it will add other entry rather than updating previous entry of employee.
    @PutMapping("/employees")
    public Employee  updateEmployeeInfo(@RequestBody Employee theEmployee )
    {
        employeeService.save(theEmployee);
        return theEmployee;
    }


    //Showed error for transactional.
    @DeleteMapping("/employees/{employeeId}")
    @Transactional 
    public String deleteEmployee(@PathVariable int employeeId)
    {
        System.out.println("Hello 1");
        Employee theEmployeeTemp = employeeService.findById(employeeId);
        System.out.println("Hello 2");
        if(theEmployeeTemp == null)
        {
            System.out.println("Hello 12");
            throw new RuntimeException(" EMployee id not found!!"+employeeId);
        }
        System.out.println("Hello 3");

        employeeService.deleteById(employeeId);
        System.out.println("Hello 4");

        return "Deleted employee id is"+employeeId; 
    }












}
