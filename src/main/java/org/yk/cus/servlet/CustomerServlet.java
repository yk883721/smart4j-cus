package org.yk.cus.servlet;


import org.yk.cus.model.Customer;
import org.yk.cus.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author admin
 */
@WebServlet("/customer_search")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Customer> customerList = customerService.getCustomerList(null);

        req.setAttribute("customerList", customerList);
        req.getRequestDispatcher("WEB-INF/view/customer.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
