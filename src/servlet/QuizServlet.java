package servlet;

import model.Question;
import service.QuestionService;
import service.QuizService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by msi on 5/19/2016.
 */
public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Question> getList= new QuestionService().questionList();
        String answer[]=request.getParameterValues("answer");
        int count=0;
        for(int i=0;i<answer.length;i++)
        {
        for(Question question:getList)
        {
            if(answer[i].equals(question.getRightAnswer()))
            {
                count++;

            }
            System.out.println("the right answers: " + question.getRightAnswer());
        }
        }

        for(int i=0;i<answer.length;i++) {
            System.out.println(answer[i]);

        }



            /*for(int i=0;i<answer.length;i++)
            {*/

               /* if( answer[i].equals(question.getRightAnswer()))
                {

                    count++;

                }

            }*/
            request.setAttribute("rightAnswers",count);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("quiztaker/quiztakerresult.jsp");
            requestDispatcher.forward(request,response);







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String page= request.getParameter("page");
        List<Question> questionList=new QuestionService().questionList();
        String key;

        if(page.equals("allquestion"))
        {


            Map<String,List<String>> answer= new QuizService().answer();
            for(Map.Entry<String,List<String>>entry:answer.entrySet())
            {

                 key=entry.getKey();
                System.out.println("Questions:"+key);
                List<String> values= entry.getValue();
                System.out.println("Options: "+values.toString());

                System.out.println("---------------------------------");

            }
           request.setAttribute("questionList",questionList);
           request.setAttribute("answer", answer);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("quiztaker/quizlist.jsp");
            requestDispatcher.forward(request,response);
        }


    }
}
