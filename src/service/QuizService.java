package service;

import dbConnection.DbConnection;
import model.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by msi on 5/24/2016.
 */
public class QuizService {
    public List<String> answerList()
    {

        String query="select * from question";
        List<String> answerList= new ArrayList<String>();
        String options[]= new String[4];
        try
        {
            PreparedStatement preparedStatement= new DbConnection().getConnection().prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Question question= new Question();
                question.setId(resultSet.getInt("id"));
                question.setQuestion(resultSet.getString("question"));
                question.setOptionA(resultSet.getString("optionA"));

                question.setOptionB(resultSet.getString("optionB"));

                question.setOptionC(resultSet.getString("optionC"));

                question.setRightAnswer(resultSet.getString("rightAnswer"));

                answerList.add(question.getOptionA());
                answerList.add(question.getOptionB());
                answerList.add(question.getOptionC());
                answerList.add(question.getRightAnswer());
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return answerList;
    }
    public Map<String,List<String>> answer()
    {

        Map<String,List<String>> answer= new HashMap<String, List<String>>();
        String query="select * from question";
        List<String> answerList;
        String options[]= new String[4];
        try
        {
            PreparedStatement preparedStatement= new DbConnection().getConnection().prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                answerList= new ArrayList<String>();
                Question question= new Question();
                question.setId(resultSet.getInt("id"));
                question.setQuestion(resultSet.getString("question"));
                question.setOptionA(resultSet.getString("optionA"));
                question.setOptionB(resultSet.getString("optionB"));
                question.setOptionC(resultSet.getString("optionC"));
                question.setRightAnswer(resultSet.getString("rightAnswer"));
                answerList.add(question.getOptionA());
                answerList.add(question.getOptionB());
                answerList.add(question.getOptionC());
                answerList.add(question.getRightAnswer());
                Collections.shuffle(answerList);
                answer.put(question.getQuestion(),answerList);

            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return answer;
    }


}
