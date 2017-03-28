package servlet;

import model.Question;
import service.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by msi on 5/19/2016.
 */
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query= request.getParameter("query");
        if(query.equals("addnewquestion"))
        {
            Question question= new Question();
            question.setQuestion(request.getParameter("question"));

            question.setOptionA(request.getParameter("optionA"));
            question.setOptionB(request.getParameter("optionB"));
            question.setOptionC(request.getParameter("optionC"));
            question.setRightAnswer(request.getParameter("rightAnswer"));
            new QuestionService().addQuestion(question);
            List<Question> questionList= new QuestionService().questionList();
            Collections.shuffle(questionList);
            request.setAttribute("questionList",questionList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/userlist.jsp");
            requestDispatcher.forward(request,response);

        }
        if(query.equals("questionupdate"))
        {

            Question question= new Question();
            question.setId(Integer.parseInt(request.getParameter("id")));
            System.out.println(question.getId());
            question.setQuestion(request.getParameter("question"));
            question.setOptionA(request.getParameter("optionA"));
            question.setOptionB(request.getParameter("optionB"));
            question.setOptionC(request.getParameter("optionC"));
            question.setRightAnswer(request.getParameter("rightAnswer"));
            new QuestionService().update(question);
            List<Question> questionList= new QuestionService().questionList();
            request.setAttribute("questionList",questionList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/userlist.jsp");
            requestDispatcher.forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String query= request.getParameter("query");
        if(query.equals("view"))
        {

            List<Question> questionList= new QuestionService().questionList();
            request.setAttribute("questionList",questionList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/userlist.jsp");
            requestDispatcher.forward(request,response);
        }
        if(query.equals("add"))
        {
            List<Question> questionList= new QuestionService().questionList();
            request.setAttribute("questionList",questionList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/adduser.jsp");
            requestDispatcher.forward(request,response);
        }
        if(query.equals("edit"))
        {
            int id= Integer.parseInt(request.getParameter("id"));
            Question question= new QuestionService().getQuestionByID(id);
            request.setAttribute("question", question);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/userform.jsp");
            requestDispatcher.forward(request,response);
        }
        if(query.equals("delete"))
        {
            int id= Integer.parseInt(request.getParameter("id"));
            new QuestionService().deleteQuestionById(id);
            List<Question> questionList= new QuestionService().questionList();
            request.setAttribute("questionList",questionList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("user/userlist.jsp");
            requestDispatcher.forward(request,response);

        }
    }
}
