package com.example.controller;

import com.example.datalayer.CustomerRepositury;
import com.example.model.Customer;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by yaaa0616 on 3/6/2017.
 */



@RestController

@EnableAutoConfiguration

@RequestMapping
@Api(value = "Customer Information",tags="Customer Info",description = "This is the api documentation using the swagger.")
public class CustomerController {

    @Autowired
    private CustomerRepositury customerRepositury;

    @ApiOperation(value = "Get customers by last name", notes="get greeting",nickname = "getGreeting",
            response = Customer.class,
            responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)


    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = Customer.class, responseContainer = "List") })

    @RequestMapping(value="/customers",method =RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Customer> getAllCustomers(){
        return customerRepositury.findAll();
    }



    @RequestMapping("/customers/{firstname}")
    private Customer getOneCustomer(@PathVariable String firstname){
        return customerRepositury.findByFirstname(firstname);
    }

    @RequestMapping(method= RequestMethod.POST,value = "/customers")
    private void createCustomer(@ApiParam(value="customer",required = true)@RequestBody Customer  customer){
        customerRepositury.save(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/customers/{id}/{firstname}")
    private void deleteCustomer(@ApiParam(value = "testId", allowableValues = "range[1,200]",
            required = true, defaultValue = "111")@PathVariable String id,@ApiParam(value = "firstname",required = false,defaultValue = "111")@PathVariable String firstname){
        customerRepositury.delete(id);
    }


}
