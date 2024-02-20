package online_library_management_system;
import java.sql.*;
public class BorrowBook
{
    String q,q1,bookName,aname,genre;
    int n,price;
    ResultSet rs;

    // for borrowing book
    public void borrowBook(String bname)
    {
        try
        {
            Conn c = new Conn();
            q = "SELECT * FROM library WHERE bname = '"+bname+"'";
            rs = c.s.executeQuery(q);
            if(!rs.isBeforeFirst())
            {
                System.out.println("Book not found");
            }
            else
            {
                while(rs.next())
                {
                    bookName = rs.getString("bname");
                    aname = rs.getString("aname");
                    genre = rs.getString("genre");
                    price = rs.getInt("price");
                }
                q1 = "INSERT INTO borrow(bname,aname,genre,price) VALUES('"+bookName+"','"+aname+"','"+genre+"','"+price+"')";
                n = c.s.executeUpdate(q1);
                if(n==1)
                {
                    System.out.println("Book borrowed successfully");
                }
                else
                {
                    System.out.println("Failed to borrow book");
                }
                rs.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        BorrowBook ob = new BorrowBook();
    }
}
