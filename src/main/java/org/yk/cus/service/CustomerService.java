package org.yk.cus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yk.cus.helper.DatabaseHelper;
import org.yk.cus.model.Customer;
import org.yk.cus.util.PropsUtil;
import org.yk.cus.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author admin
 */
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getCustomerList(String keyword) {

        String sql = "SELECT id, name, contact, telephone, email, remark FROM `customer`;";
        if (StringUtils.isNotNullOrBlank(keyword)) {
            sql += "WHERE name like '%" + keyword + "%'";
        }

        return DatabaseHelper.queryEntityList(Customer.class, sql);

    }

    public Customer getCustomer(Long id) {
        String sql = "SELECT id, name, contact, telephone, email, remark FROM `customer` WHERE id = ?;";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {

        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    public boolean updateCustomer(Long id, Map<String, Object> fieldMap) {

        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    public boolean deleteCustomer(Long id) {

        return DatabaseHelper.deleteEntity(Customer.class, id);
    }


}
