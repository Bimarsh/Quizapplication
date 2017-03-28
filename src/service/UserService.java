package service;

import dbConnection.DbConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msi on 5/18/2016.
 */
public class UserService {
    public User loginCheck(User user)
    {

        User user1= new User();
        try
        {

            String query="select * from user where name=? and password=?";
            PreparedStatement statement= new DbConnection().getConnection().prepareStatement(query);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            ResultSet resultSet=statement.executeQuery();

            if(resultSet.next())
            {


                user1.setValid(true);
                user1.setRole(resultSet.getString("role"));
                user1.setName(resultSet.getString("name"));


            }



        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return user1;

    }
    public List<User> userlist()
    {
        List<User> userList= new ArrayList<User>();
        try
        {
            String query="select * from user";
            PreparedStatement statement= new DbConnection().getConnection().prepareStatement(query);
            ResultSet resultSet= statement.executeQuery();
            while(resultSet.next())
            {
                User user= new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                userList.add(user);

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  userList;
    }
    public void addUser(User user) {

        String query = "insert into user (name,password,role) values (?,?,?)";

        try {
            PreparedStatement pstm = new DbConnection().getConnection().prepareStatement(query);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getPassword());
            pstm.setString(3,user.getRole());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // return user;
    }
    public User getUserById(int id) {
        User user = null;
        // System.out.println(id);
        String query = "select * from user where id=?";

        try {
            PreparedStatement pstm = new DbConnection().getConnection().prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            //    System.out.println(rs);

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                // System.out.println(user.getName());
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    public void updateUser(User user) {

        String query = "update user set name=?, password=?,role=? where id=?";

        try {
            PreparedStatement pstm = new DbConnection().getConnection().prepareStatement(query);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getPassword());
            pstm.setString(3,user.getRole());
            pstm.setInt(4, user.getId());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void deleteUserById(int id) {
        User user = null;
        // System.out.println(id);
        String query = "delete from user where id=?";

        try {
            PreparedStatement pstm = new DbConnection().getConnection().prepareStatement(query);
            pstm.setInt(1, id);
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
