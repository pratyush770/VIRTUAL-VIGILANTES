package online_library_management_system;

import java.sql.*;
public class BookCatalog
{
    String q;
    int n;
    ResultSet rs;

    // for viewing book catalog
    public void viewBooks()
    {
        try
        {
            Conn c = new Conn();
            q = "SELECT * FROM library";
            rs = c.s.executeQuery(q);
            if(!rs.isBeforeFirst())
            {
                System.out.println("Please add a book to view book catalog");
            }
            else
            {
                System.out.println("The details of books are as follows : ");
                while(rs.next())
                {
                    System.out.println(rs.getInt(1) + " " + " " + rs.getString(2) + " " + " " + rs.getString(3) +
                            " " + " " + rs.getString(4) + " " + " " + rs.getInt(5));
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
        BookCatalog ob = new BookCatalog();
    }
}
