package service;

import dbConnection.DbConnection;
import model.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by msi on 5/18/2016.
 */
public class QuestionService {
    public List<Question> questionList()
    {
        String query="select * from question";
        List<Question> questionList= new ArrayList<Question>();

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

                questionList.add(question);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return questionList;
    }
    public void addQuestion(Question question)
    {
        String query="insert into question(question,optionA,optionB,optionC,rightAnswer)values(?,?,?,?,?)";
        try
        {
            PreparedStatement preparedStatement= new DbConnection().getConnection().prepareStatement(query);
            preparedStatement.setString(1,question.getQuestion());
            preparedStatement.setString(2,question.getOptionA());
            preparedStatement.setString(3,question.getOptionB());
            preparedStatement.setString(4,question.getOptionC());
            preparedStatement.setString(5,question.getRightAnswer());
            preparedStatement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void update(Question question )
    {
        String query= "update question set question=?,optionA=?,optionB=?,optionC=?,rightAnswer=? where id=?";
        try
        {
            PreparedStatement preparedStatement= new DbConnection().getConnection().prepareStatement(query);
            preparedStatement.setString(1,question.getQuestion());
            preparedStatement.setString(2,question.getOptionA());
            preparedStatement.setString(3,question.getOptionB());
            preparedStatement.setString(4,question.getOptionC());
            preparedStatement.setString(5,question.getRightAnswer());
            preparedStatement.setInt(6,question.getId());
            preparedStatement.execute();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public Question getQuestionByID(int id)
    {
        Question question= new Question();
        String query="select * from question where id=?";
        try
        {
            PreparedStatement preparedStatement= new DbConnection().getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next())
            {

                question.setId(resultSet.getInt("id"));
                question.setQuestion(resultSet.getString("question"));
                question.setOptionA(resultSet.getString("optionA"));
                question.setOptionB(resultSet.getString("optionB"));
                question.setOptionC(resultSet.getString("optionC"));
                question.setRightAnswer(resultSet.getString("rightAnswer"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return question;

    }

    public void deleteQuestionById(int id )
    {
        String query="delete from question where id=?";
        try
        {
            PreparedStatement preparedStatement= new DbConnection().getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
    public List<Question> byIDandAnswer()
    {
        String query="select * from question";
        List<Question> questionList= new ArrayList<Question>();
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
                questionList.add(question);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return questionList;

    }


}
