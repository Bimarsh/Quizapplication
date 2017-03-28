package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by msi on 5/18/2016.
 */
public class DbConnection {
    private final String username="root";
    private final String password="";
    private final String url="jdbc:mysql://localhost:3306/demo_db";
    Connection connection =null;
    public DbConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(url, username, password);
            System.out.println("Successful Db connection");
        }
        catch (SQLException e)
        {
            System.out.println("Error in Connection");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public final Connection getConnection()
    {
        return connection;
    }
    public  final Statement getStatement() throws SQLException
    {

        return  connection.createStatement();
    }

}
