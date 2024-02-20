package online_library_management_system;

import java.sql.*;
public class Conn
{
    Connection c;
    String url,uname,pwd;
    Statement s;
    public Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");  // for loading the driver
            url = "jdbc:mysql://localhost:3307/librarydb";  // url of the database
            uname = "root";  // username is always root
            pwd = "matsumoto";  // password of the database
            c = DriverManager.getConnection(url,uname,pwd);
            s = c.createStatement();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        // no main method as we are passing this constructor to other classes
    }
}