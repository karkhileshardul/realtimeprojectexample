
///USing Native Hibernate APII

package com.shardul.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.shardul.entity.Employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImplementation implements Employeedao {

    //define field for entitymanager
    private EntityManager entityManager;
    
    //set up constructor injection
    @Autowired
    public EmployeeDAOImplementation(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }

//     @Transactional :- starts and commit transaction in background.
    @Override
    // @Transactional we will remove this as we will add a Service to handle 
    public List<Employee> findAll() {
        
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        // Query<Employee> theQuery = currentSession.createQuery("from Employee where first_name='Shriyash'",Employee.class);
        Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        // return the results

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        
        //get the current hibernate session.
        Session currentSession =entityManager.unwrap(Session.class);

        //get the employee
        Employee theEmployee = currentSession.get(Employee.class,theId);

        //return the employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        //get the current hibernate session.
        Session curentSession = entityManager.unwrap(Session.class);

        //save employee
        curentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {

        //get the current hibernate session.
        Session currentSession = entityManager.unwrap(Session.class);
        
        //delete object with primary key.
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
    
}



