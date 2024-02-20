package online_library_management_system;

import java.sql.*;
import java.util.*;
public class EditBook
{
    String q,enteredColumn,bname,aname,genre;
    int n,id,price;
    Scanner sc;
    ResultSet rs;

    // for editing a book
    public void editBook(int id)
    {
        sc = new Scanner(System.in);
        System.out.print("Enter the column you want to update('book','author','genre','price') : ");
        enteredColumn = sc.nextLine();
        switch (enteredColumn)
        {
            case "book":
            case "Book":
            case "BOOK":
                try
                {
                    // for editing book name
                    System.out.print("Enter the name of the book you want to update : ");
                    bname = sc.nextLine();
                    Conn c = new Conn();
                    q = "UPDATE library SET bname = '"+bname+"' WHERE bid = '"+id+"'";
                    n = c.s.executeUpdate(q);
                    if(n==1)
                    {
                        System.out.println("Book name updated successfully");
                    }
                    else
                    {
                        System.out.println("Failed to update book name");
                    }
                    System.out.println("The details of the book after editing are : ");
                    q = "SELECT * FROM library WHERE bid = '"+id+"'";
                    rs = c.s.executeQuery(q);
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1) + " " + " " + rs.getString(2) + " " + " " + rs.getString(3) +
                                " " + " " + rs.getString(4) + " " + " " + rs.getInt(5));
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case "author":
            case "Author":
            case "AUTHOR":
                try
                {
                    // for editing author name
                    System.out.print("Enter the name of the author you want to update : ");
                    aname = sc.nextLine();
                    Conn c = new Conn();
                    q = "UPDATE library SET aname = '"+aname+"' WHERE bid = '"+id+"'";
                    n = c.s.executeUpdate(q);
                    if(n==1)
                    {
                        System.out.println("Author name updated successfully");
                    }
                    else
                    {
                        System.out.println("Failed to update author name");
                    }
                    System.out.println("The details of the book after editing are : ");
                    q = "SELECT * FROM library WHERE bid = '"+id+"'";
                    rs = c.s.executeQuery(q);
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1) + " " + " " + rs.getString(2) + " " + " " + rs.getString(3) +
                                " " + " " + rs.getString(4) + " " + " " + rs.getInt(5));
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case "genre":
            case "Genre":
            case "GENRE":
                try
                {
                    // for editing genre of the book
                    System.out.print("Enter the genre of the book you want to update : ");
                    genre = sc.nextLine();
                    Conn c = new Conn();
                    q = "UPDATE library SET genre = '"+genre+"' WHERE bid = '"+id+"'";
                    n = c.s.executeUpdate(q);
                    if(n==1)
                    {
                        System.out.println("Genre updated successfully");
                    }
                    else
                    {
                        System.out.println("Failed to update genre");
                    }
                    System.out.println("The details of the book after editing are : ");
                    q = "SELECT * FROM library WHERE bid = '"+id+"'";
                    rs = c.s.executeQuery(q);
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1) + " " + " " + rs.getString(2) + " " + " " + rs.getString(3) +
                                " " + " " + rs.getString(4) + " " + " " + rs.getInt(5));
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case "price":
            case "Price":
            case "PRICE":
                try
                {
                    // for editing price of the book
                    System.out.print("Enter the price of the book you want to update : ");
                    price = sc.nextInt();
                    sc.nextLine();
                    Conn c = new Conn();
                    q = "UPDATE library SET price = '"+price+"' WHERE bid = '"+id+"'";
                    n = c.s.executeUpdate(q);
                    if(n==1)
                    {
                        System.out.println("Price updated successfully");
                    }
                    else
                    {
                        System.out.println("Failed to update price");
                    }
                    System.out.println("The details of the book after editing are : ");
                    q = "SELECT * FROM library WHERE bid = '"+id+"'";
                    rs = c.s.executeQuery(q);
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1) + " " + " " + rs.getString(2) + " " + " " + rs.getString(3) +
                                " " + " " + rs.getString(4) + " " + " " + rs.getInt(5));
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }
    public static void main(String[] args)
    {
        EditBook ob = new EditBook();
    }
}
