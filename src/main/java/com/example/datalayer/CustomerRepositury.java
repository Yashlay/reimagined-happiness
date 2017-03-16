package com.example.datalayer;

import com.example.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by yaaa0616 on 3/2/2017.
 */

@RepositoryRestResource
public interface CustomerRepositury extends MongoRepository <Customer,String>{


    public Customer findByFirstname(String firstname);
    public List<Customer> findByLastname(String lastname);
}
