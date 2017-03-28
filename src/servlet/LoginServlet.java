package servlet;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by msi on 5/18/2016.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        User user = new User();

        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        User user1= new UserService().loginCheck(user);
        if(user1.isValid())
        {
            HttpSession session = request.getSession(false);
            session.setAttribute("user",user1);
            request.setAttribute("message","Login Successful");
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request,response);
        }

        else
        {
            request.setAttribute("message","Login Failed");
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
