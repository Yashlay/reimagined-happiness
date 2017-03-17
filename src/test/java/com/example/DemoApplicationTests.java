package com.example;

import com.example.controller.CustomerController;
import com.example.datalayer.CustomerRepositury;
import com.example.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(MockitoJUnitRunner.class)
public class DemoApplicationTests {
    private MockMvc mockmvc;


    @Mock
    private CustomerRepositury customerrepository;



    @InjectMocks
    private CustomerController customerController;

    @Before
    public void setUp() {
        mockmvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void get_all_customers() throws Exception{
        List<Customer> customers = Arrays.asList(new Customer("2","ABC3","DEF"));
        //when(customerController.getAllCustomers()).thenReturn(customers);
        when(customerrepository.findAll()).thenReturn(customers);


        mockmvc.perform(get("/customers")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id", is("2")))
        .andExpect(jsonPath("$[0].firstname", is("ABC3")))
        .andExpect(jsonPath("$[0].lastname", is("DEF")));
        

    }



}
