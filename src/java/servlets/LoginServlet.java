package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.AccountService;
import models.User;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        AccountService as = new AccountService();
        User user = as.login(username, password);
        if(username == null || username.equals("") || password == null || password.equals("") && user != null)
        {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
            request.setAttribute("error", true);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else if(user == null)
        {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("loginError", true);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
            response.sendRedirect("home");
    }

}
