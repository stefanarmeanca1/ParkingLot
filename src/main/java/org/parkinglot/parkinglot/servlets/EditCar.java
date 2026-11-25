package org.parkinglot.parkinglot.servlets;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.parkinglot.parkinglot.common.CarDTO;
import org.parkinglot.parkinglot.common.UserDTO;
import org.parkinglot.parkinglot.ejb.CarsBean;
import org.parkinglot.parkinglot.ejb.UserBean;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditCar", value = "/EditCar")
public class EditCar extends HttpServlet
{
    @Inject
    UserBean usersBean;

    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException
    {
        List<UserDTO> users = usersBean.findAllUsers();

        Long carId = Long.parseLong(request.getParameter("id"));
        CarDTO car = carsBean.findByID(carId);

        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/views/editCar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }
}