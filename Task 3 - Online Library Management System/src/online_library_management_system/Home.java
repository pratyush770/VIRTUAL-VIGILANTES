package online_library_management_system;
import java.sql.*;
import java.util.*;
public class Home
{
    static int ch,price,id;
    static Scanner sc;
    static String bname,aname,genre;
    public static void main(String[] args)
    {
        System.out.println("\tWelcome to online library management system");
        System.out.println();
        do
        {
            System.out.println("1) Add book");
            System.out.println("2) Edit book");
            System.out.println("3) Delete book");
            System.out.println("4) Borrow book");
            System.out.println("5) View borrowing history");
            System.out.println("6) View book catalog");
            System.out.println("7) Check book");
            System.out.println("8) Exit");
            System.out.println();
            sc = new Scanner(System.in);
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.print("Enter the name of the book : ");
                    sc.nextLine();
                    bname = sc.nextLine();
                    System.out.print("Enter the name of the author : ");
                    aname = sc.nextLine();
                    System.out.print("Enter the genre/category of the book : ");
                    genre = sc.nextLine();
                    System.out.print("Enter the price of the book : ");
                    price = sc.nextInt();
                    sc.nextLine();
                    new AddBook().addBook(bname,aname,genre,price);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the id of the book : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    new EditBook().editBook(id);
                    break;
                case 3:
                    System.out.print("Enter the name of the book you want to delete : ");
                    sc.nextLine();
                    bname = sc.nextLine();
                    new DeleteBook().deleteBook(bname);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter the name of the book you want to borrow : ");
                    sc.nextLine();
                    bname = sc.nextLine();
                    new BorrowBook().borrowBook(bname);
                    System.out.println();
                    break;
                case 5:
                    new BorrowBookHistory().borrowBookHistory();
                    System.out.println();
                    break;
                case 6:
                    new BookCatalog().viewBooks();
                    System.out.println();
                    break;
                case 7:
                    System.out.print("Enter the name of the book you want to check : ");
                    sc.nextLine();
                    bname = sc.nextLine();
                    new CheckBook().checkBook(bname);
                    System.out.println();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Wrong choice");
                    System.out.println();
            }
        }
        while(ch!=8);
    }
}
