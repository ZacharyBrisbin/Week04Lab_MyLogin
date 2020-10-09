package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.*;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String username = (String)request.getSession().getAttribute("username");
        String password = (String)request.getSession().getAttribute("password");
        if(username == null || password == null)
        {
            username = "hello";
            password = "there";
        }
        AccountService as = new AccountService();
        User user = as.login(username, password);
        
        if(user == null || session.isNew())
            response.sendRedirect("login");

        else 
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
    }

}
