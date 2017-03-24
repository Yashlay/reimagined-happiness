package com.example.datalayer;

import com.example.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by yaaa0616 on 3/2/2017.
 */

@RepositoryRestResource
public interface CustomerRepositury extends MongoRepository <Customer,String>{

    @Query("{ 'lastname' : ?0 }")
    public Customer findByFirstname(String firstname);
    @Query("{ 'lastname' : { $exists: true }}")
    public Boolean findifexists();
    public List<Customer> findByLastname(String lastname);
/*
    public List<Customer> findByIdAndLastname(String id, String lastname);
    public List<Customer> findbyAgeBetween(int ageGT,int ageLT);
    // Enables the distinct flag for the query
    public List<Customer> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
    public List<Customer> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

    // Enabling ignoring case for an individual property
    public List<Customer> findByLastnameIgnoreCase(String lastname);
    // Enabling ignoring case for all suitable properties
    public List<Customer> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

    // Enabling static ORDER BY for a query
    public List<Customer> findByLastnameOrderByFirstnameAsc(String lastname);
    public List<Customer> findByLastnameOrderByFirstnameDesc(String lastname);*/
}
