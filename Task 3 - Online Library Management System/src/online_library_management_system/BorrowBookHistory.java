package online_library_management_system;

import java.sql.*;
public class BorrowBookHistory
{
    String q;
    ResultSet rs;

    // for viewing borrowing history
    public void borrowBookHistory()
    {
        try
        {
            Conn c = new Conn();
            q = "SELECT * FROM borrow";
            rs = c.s.executeQuery(q);
            if(!rs.isBeforeFirst())
            {
                System.out.println("No books borrowed yet");
            }
            else
            {
                System.out.println("The borrowed books are : ");
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
        BorrowBookHistory ob = new BorrowBookHistory();
    }
}
