package servlet;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by msi on 5/18/2016.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page=request.getParameter("page");
        if(page.equals("adduser"))
        {
            User user= new User();
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));
            new UserService().addUser(user);
            List<User> userList= new UserService().userlist();
            request.setAttribute("userList",userList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/userlist.jsp");
            requestDispatcher.forward(request,response);


        }
        else if(page.equals("update"))
        {
            User user= new User();
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));
            user.setId(Integer.parseInt(request.getParameter("id")));
            new UserService().updateUser(user);
            List<User> userList= new UserService().userlist();
            request.setAttribute("userList",userList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/userlist.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page=request.getParameter("page");
        if(page.equals("list"))
        {
          List<User> userList= new UserService().userlist();
            request.setAttribute("userList",userList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/userlist.jsp");
            requestDispatcher.forward(request,response);

        }
        else if(page.equals("add"))
        {
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/adduser.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(page.equals("edit"))
        {
            int id=Integer.parseInt(request.getParameter("id"));
            User user= new UserService().getUserById(id);
            request.setAttribute("userform", user);
            RequestDispatcher rd = request.getRequestDispatcher("user/userform.jsp");
            rd.forward(request, response);

        }
        else  if(page.equals("delete"))
        {
            int id= Integer.parseInt(request.getParameter("id"));
            new UserService().deleteUserById(id);
            List<User> userList= new UserService().userlist();
            request.setAttribute("userList",userList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/userlist.jsp");
            requestDispatcher.forward(request,response);

        }


    }
}
