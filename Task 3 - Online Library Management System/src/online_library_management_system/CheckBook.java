package online_library_management_system;

import java.sql.*;
public class CheckBook
{
    String q;
    int n;
    ResultSet rs;

    // for checking a specific book
    public void checkBook(String bname)
    {
        try
        {
            Conn c = new Conn();
            q = "SELECT * FROM library WHERE bname = '"+bname+"'";
            rs = c.s.executeQuery(q);
            if(!rs.isBeforeFirst())  // checks if the entered book exists in the database
            {
                System.out.println("Book not found");
            }
            else
            {
                System.out.println("The details of the entered book name is : ");
                while(rs.next())
                {
                    System.out.println(rs.getString("bname") + " " + " " + rs.getString("aname") + " " + " " +
                            rs.getString("genre") + " " + " " + rs.getInt("price"));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        CheckBook ob = new CheckBook();
    }
}
