package online_library_management_system;
public class AddBook
{
    String q;
    int n;

    // for adding book
    public void addBook(String bname,String aname,String genre,int price)
    {
        try
        {
            Conn c = new Conn();
            q = "INSERT INTO library(bname,aname,genre,price) VALUES('"+bname+"','"+aname+"','"+genre+"','"+price+"')";
            n = c.s.executeUpdate(q);
            if(n==1)
            {
                System.out.println("Book added successfully");
            }
            else
            {
                System.out.println("Failed to add book");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        AddBook ob = new AddBook();
    }
}
