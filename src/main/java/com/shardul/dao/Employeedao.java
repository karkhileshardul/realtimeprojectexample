package com.shardul.dao;

import java.util.List;

import com.shardul.entity.Employee;

public interface Employeedao {
    

    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);

    public void deleteById(int theId);
    
}
