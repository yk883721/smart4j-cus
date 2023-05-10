package test;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceTest {

    private CustomerService customerService;

    @Before
    public void init() {
        customerService = new CustomerService();
    }

    @Test
    public void customerListTest() {

        List<Customer> customerList = customerService.getCustomerList(null);
        Assert.assertEquals(2, customerList.size());

    }

    @Test
    public void customerInfoTest() {

        Long id = 1L;

        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);

    }

    @Test
    public void createCustomerTest() {

        Map<String, Object> fieldMap = new HashMap<>();

        fieldMap.put("name", "customer100");
        fieldMap.put("contact", "John");
        fieldMap.put("telephone", "18888888888");


        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);

    }

    @Test
    public void updateCustomerTest() {

        Long id = 1L;

        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("contact", "bob");

        boolean result = customerService.updateCustomer(id, fieldMap);
        Assert.assertTrue(result);

    }

    @Test
    public void deleteCustomerTest() {

        Long id = 1L;

        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);

    }



}