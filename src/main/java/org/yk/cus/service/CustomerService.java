package org.yk.cus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {

        Properties properties = PropsUtil.loadProps("jdbc.properties");

        DRIVER = PropsUtil.getString(properties, "jdbc.driver");
        URL = PropsUtil.getString(properties, "jdbc.url");
        USERNAME = PropsUtil.getString(properties, "jdbc.username");
        PASSWORD = PropsUtil.getString(properties, "jdbc.password");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("can not load jdbc driver", e);
        }
    }

    public List<Customer> getCustomerList(String keyword) {

        Connection conn = null;
        try {
            List<Customer> customers = new ArrayList<>();


            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "SELECT id, name, contact, telephone, email, remark FROM `customer`;";
            if (StringUtils.isNotNullOrBlank(keyword)) {
                sql += "WHERE name like '%" + keyword + "%'";
            }

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Customer customer = new Customer();

                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));

                customers.add(customer);
            }

            return customers;

        } catch (SQLException exception) {
            logger.error("execute sql failure", exception);

            return new ArrayList<>();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException exception) {
                    logger.error("close connection failure", exception);
                }
            }
        }

    }

    public Customer getCustomer(Long id) {

        return null;
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {

        return false;
    }

    public boolean updateCustomer(Long id, Map<String, Object> fieldMap) {

        return false;
    }

    public boolean deleteCustomer(Long id) {

        return false;
    }


}
