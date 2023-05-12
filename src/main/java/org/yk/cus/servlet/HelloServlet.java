package org.yk.cus.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String curTime = LocalDate.now().toString();

        req.setAttribute("currentTime", curTime);
        req.getRequestDispatcher("WEB-INF/jsp/hello.jsp").forward(req, resp);

    }

}
