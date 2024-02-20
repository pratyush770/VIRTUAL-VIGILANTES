package online_library_management_system;
public class DeleteBook
{
    String q;
    int n;

    // for deleting book
    public void deleteBook(String bname)
    {
        try
        {
            Conn c = new Conn();
            q = "DELETE FROM library WHERE bname = '"+bname+"'";
            n = c.s.executeUpdate(q);
            if(n==1)
            {
                System.out.println("Book deleted successfully");
            }
            else
            {
                System.out.println("Failed to delete book");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        DeleteBook ob = new DeleteBook();
    }

}
