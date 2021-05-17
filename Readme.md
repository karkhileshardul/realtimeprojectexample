Create a REST API for the Employee Directory

REST clients should be able to 
1. Get a list of Employees. (/api/employees)  (GET)
2. Get a single employee by id. (/api/employees/{employeeIs})  (GET)
3. Add a new employee.  (/api/employees)  (POST)
4. Update an employee. (/api/employees)   (PUT)
5. Delete an employee. (/api/employees/{employeeIs})  (DELETE)



Architecture:----
    REST Controller ---> Service ---> DAO ---> DAO will make use of Hibernate to connect to backend database.

    DAO ---> Session Factory (they need data source) ---> Data Source (they define database connection info) 
    { adhi in Spring config XMl then in JAVA define data source, your session factory and transaction Manager}
    { ata automatically configure data source, from pom file whether mysql or different require will sort out  that and database connection info from application.properties}
    { no need to give JDBC driver class name, automatically get detected from URL}
    { data soource properties available to configure connection pool }

    {Based on configs, it will automatically create java beans DataSource, EntityManager is from JPA}

*****JPA:---
JPA is specification.
There are two present Hibernate and Eclipse Link

Various DAO techniques:--
1. Version 1: Use EntityManager but leverage native Hibernate API.
2. Version 2: Use EntityManager and standard JPA API.
3. Version 3: Spring Data JPA.

Version 1 Use EntityManager but leverage native . 
Version 2 Use EntityManager and standard JPA API.
Version 3 Spring Data JPA.




*****Version 2

-Benifits of Version 2
    We are not locked to vendor's Implementation.
    We can switch to different vendors if one we are using stops providind support
    Poratable and flxible code.

****Compare JPA to Native Hibernate Methods
----------------------------|------------------------------|-----------------------------------|
                            |    Native Hiberante Methods  |            JPA methods            |                        
----------------------------|------------------------------|-----------------------------------|
                            |                              |                                   |
Create/ Save new Entity     |       session.save(...)      |   entityManager.persist(...)      |
                            |                              |                                   |
----------------------------|------------------------------|-----------------------------------|
                            |                              |                                   |
Retrieve Entity by id       |   session.get(...)/load(..)  |   entityManager.find(...)
                            |                              |                                   |
----------------------------|------------------------------|-----------------------------------|    
                            |                              |                                   |
Retrieve list of entries    |   session.createQuery(...)   |   entityManager.createQuery(..)   |                
                            |                              |                                   |
----------------------------|------------------------------|-----------------------------------|
                            |                              |                                   |
Save or update entity       |   session.saveOrUpdate(...)  |   entityManager.merge(...)        |
                            |                              |                                   |
----------------------------|------------------------------|-----------------------------------|
                            |                              |                                   |
Delete entity               |   sesson.delete(...)         |   entityManager.remove(...)       |
                            |                              |                                   |
----------------------------|------------------------------|-----------------------------------|



*****Qualifier
When you have two implementations of Hibernate then the one which you want to use can be used via giving it a "@Qualifier" in Constructor and inside it giving name of Class which you want to use but the name's initial should be small rest no issues. 


*****Version 3 Spring JPA

 REST Controller ---> Service ---> DAO (Spring Data JPA) ---> DAO will make use of Hibernate to connect to backend database.


pom.xml
    JPA, Mysql driver required

{
    ERROR:---
        MYSQL - Warning: #1681 Integer display width is deprecated

    ANSWER:---
        https://stackoverflow.com/questions/58938358/mysql-warning-1681-integer-display-width-is-deprecated
}