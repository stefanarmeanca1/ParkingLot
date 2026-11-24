package org.parkinglot.parkinglot.servlets;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.parkinglot.parkinglot.common.CarDTO;
import org.parkinglot.parkinglot.common.UserDTO;
import org.parkinglot.parkinglot.ejb.UserBean;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet
{
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException
    {
        List<UserDTO> users = userBean.findAllUsers();
        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException
    {
    }
}