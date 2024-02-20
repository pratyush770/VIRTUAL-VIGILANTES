package student_grade_tracker;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class EditStudent extends JFrame implements ActionListener
{
    JLabel sid,sname,course,mark1,mark2,mark3,mark4,mark5,average,sgrade;
    JTextField sidText,snameText,courseText,mark1Text,mark2Text,mark3Text,mark4Text,mark5Text,avgText,gradeText;
    JButton update;
    Scanner sc;
    ResultSet rs;
    String name,scourse,q,grade,updateColumn;
    int id,m1,m2,m3,m4,m5,sum,avg;
    char ch;
    Conn c;
    EditStudent()
    {
        setTitle("Student Grade Tracker");  // sets the title for the program
        setVisible(false);
        setSize(800,875);
        setResizable(false);
        setLayout(null);
        setLocation(550,70);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        sid = new JLabel("The updated student ID is : ");
        sid.setBounds(45,50,600,40);
        sid.setFont(new Font("Raleway",Font.BOLD,26));
        add(sid);
        sidText = new JTextField();
        sidText.setBounds(540,50,200,40);
        sidText.setFont(new Font("Arial",Font.PLAIN,20));
        sidText.setBackground(Color.WHITE);
        sidText.setForeground(Color.BLACK);
        add(sidText);

        sname = new JLabel("The updated student name is : ");
        sname.setBounds(45,120,600,40);
        sname.setFont(new Font("Raleway",Font.BOLD,26));
        add(sname);
        snameText = new JTextField();
        snameText.setBounds(540,120,200,40);
        snameText.setFont(new Font("Arial",Font.PLAIN,20));
        snameText.setBackground(Color.WHITE);
        snameText.setForeground(Color.BLACK);
        add(snameText );

        course = new JLabel("The updated course is : ");
        course.setBounds(45,190,600,40);
        course.setFont(new Font("Raleway",Font.BOLD,26));
        add(course);
        courseText = new JTextField();
        courseText.setBounds(540,190,200,40);
        courseText.setFont(new Font("Arial",Font.PLAIN,20));
        courseText.setBackground(Color.WHITE);
        courseText.setForeground(Color.BLACK);
        add(courseText);

        mark1 = new JLabel("The updated marks of 1st subject are : ");
        mark1.setBounds(45,260,600,40);
        mark1.setFont(new Font("Raleway",Font.BOLD,26));
        add(mark1);
        mark1Text = new JTextField();
        mark1Text.setBounds(540,260,200,40);
        mark1Text.setFont(new Font("Arial",Font.PLAIN,20));
        mark1Text.setBackground(Color.WHITE);
        mark1Text.setForeground(Color.BLACK);
        add(mark1Text);

        mark2 = new JLabel("The updated marks of 2nd subject are : ");
        mark2.setBounds(45,330,600,40);
        mark2.setFont(new Font("Raleway",Font.BOLD,26));
        add(mark2);
        mark2Text = new JTextField();
        mark2Text.setBounds(540,330,200,40);
        mark2Text.setFont(new Font("Arial",Font.PLAIN,20));
        mark2Text.setBackground(Color.WHITE);
        mark2Text.setForeground(Color.BLACK);
        add(mark2Text);

        mark3 = new JLabel("The updated marks of 3rd subject are : ");
        mark3.setBounds(45,400,600,40);
        mark3.setFont(new Font("Raleway",Font.BOLD,26));
        add(mark3);
        mark3Text = new JTextField();
        mark3Text.setBounds(540,400,200,40);
        mark3Text.setFont(new Font("Arial",Font.PLAIN,20));
        mark3Text.setBackground(Color.WHITE);
        mark3Text.setForeground(Color.BLACK);
        add(mark3Text);

        mark4 = new JLabel("The updated marks of 4th subject are : ");
        mark4.setBounds(45,470,600,40);
        mark4.setFont(new Font("Raleway",Font.BOLD,26));
        add(mark4);
        mark4Text = new JTextField();
        mark4Text.setBounds(540,470,200,40);
        mark4Text.setFont(new Font("Arial",Font.PLAIN,20));
        mark4Text.setBackground(Color.WHITE);
        mark4Text.setForeground(Color.BLACK);
        add(mark4Text);

        mark5 = new JLabel("The updated marks of 5th subject are : ");
        mark5.setBounds(45,540,600,40);
        mark5.setFont(new Font("Raleway",Font.BOLD,26));
        add(mark5);
        mark5Text = new JTextField();
        mark5Text.setBounds(540,540,200,40);
        mark5Text.setFont(new Font("Arial",Font.PLAIN,20));
        mark5Text.setBackground(Color.WHITE);
        mark5Text.setForeground(Color.BLACK);
        add(mark5Text);

        average = new JLabel("The average marks of the student is : ");
        average.setBounds(45,610,600,40);
        average.setFont(new Font("Raleway",Font.BOLD,26));
        add(average);
        avgText = new JTextField();
        avgText.setBounds(540,610,200,40);
        avgText.setFont(new Font("Arial",Font.PLAIN,20));
        avgText.setBackground(Color.WHITE);
        avgText.setForeground(Color.BLACK);
        add(avgText);

        sgrade = new JLabel("The grade obtained by the student is : ");
        sgrade.setBounds(45,680,600,40);
        sgrade.setFont(new Font("Raleway",Font.BOLD,26));
        add(sgrade);
        gradeText = new JTextField();
        gradeText.setBounds(540,680,200,40);
        gradeText.setFont(new Font("Arial",Font.PLAIN,20));
        gradeText.setBackground(Color.WHITE);
        gradeText.setForeground(Color.BLACK);
        add(gradeText);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Arial",Font.PLAIN,20));
        update.setBounds(640,750,100,40);
        add(update);
        update.addActionListener(this);

        sc = new Scanner(System.in);
        System.out.print("Enter the student id : ");
        id = sc.nextInt();
        sc.nextLine();
        userInput(id);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==update)
        {
            JOptionPane.showMessageDialog(null,"Updated Successfully");
            System.out.println("Updated Successfully");
            setVisible(false);
            new Home().setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{
            EditStudent ob =new EditStudent();
            ob.setVisible(true);
        });
    }

    public void userInput(int id)
    {
        try
        {
            System.out.print("Enter the column you want to update ('name','course','m1','m2','m3','m4','m5','average','grade') : ");
            updateColumn = sc.nextLine();
            switch (updateColumn)
            {
                case "name":
                case "Name":
                case "NAME":
                    // for editing student name
                    System.out.print("Enter the name you want to update : ");
                    name = sc.nextLine();
                    c = new Conn();
                    String q = "UPDATE student SET name = '"+name+"' WHERE id = '"+id+"'";
                    c.s.executeUpdate(q);
                    displayData(id);
                    break;
                case "course":
                case "Course":
                case "COURSE":
                    // for editing student course
                    System.out.print("Enter the course of the student you want to update : ");
                    scourse = sc.nextLine();
                    c = new Conn();
                    q = "UPDATE student SET course = '"+scourse+"' WHERE id = '"+id+"'";
                    c.s.executeUpdate(q);
                    displayData(id);
                    break;
                case "m1":
                case "M1":
                    // for editing marks of 1st subject
                    System.out.print("Enter the marks of 1st subject you want to update : ");
                    m1 = sc.nextInt();
                    sc.nextLine();
                    c = new Conn();
                    q = "UPDATE student SET m1 = '"+m1+"' WHERE id = '"+id+"'";
                    c.s.executeUpdate(q);
                    displayData(id);
                    break;
                case "m2":
                case "M2":
                    // for editing marks of 2nd subject
                    System.out.print("Enter the marks of 2nd subject you want to update : ");
                    m2 = sc.nextInt();
                    sc.nextLine();
                    c = new Conn();
                    q = "UPDATE student SET m2 = '"+m2+"' WHERE id = '"+id+"'";
                    c.s.executeUpdate(q);
                    displayData(id);
                    break;
                case "m3":
                case "M3":
                    // for editing marks of 3rd subject
                    System.out.print("Enter the marks of 3rd subject you want to update : ");
                    m3 = sc.nextInt();
                    sc.nextLine();
                    c = new Conn();
                    q = "UPDATE student SET m3 = '"+m3+"' WHERE id = '"+id+"'";
                    c.s.executeUpdate(q);
                    displayData(id);
                    break;
                case "m4":
                case "M4":
                    // for editing marks of 4th subject
                    System.out.print("Enter the marks of 4th subject you want to update : ");
                    m4 = sc.nextInt();
                    sc.nextLine();
                    c = new Conn();
                    q = "UPDATE student SET m4 = '"+m4+"' WHERE id = '"+id+"'";
                    c.s.executeUpdate(q);
                    displayData(id);
                    break;
                case "m5":
                case "M5":
                    // for editing marks of 5th subject
                    System.out.print("Enter the marks of 5th subject you want to update : ");
                    m5 = sc.nextInt();
                    sc.nextLine();
                    c = new Conn();
                    q = "UPDATE student SET m5 = '"+m5+"' WHERE id = '"+id+"'";
                    c.s.executeUpdate(q);
                    displayData(id);
                    break;
                case "average":
                case "Average":
                case "AVERAGE":
                    // for editing average marks of the student
                    System.out.print("Enter the average of the student you want to update : ");
                    avg = sc.nextInt();
                    sc.nextLine();
                    c = new Conn();
                    q = "UPDATE student SET avg = '"+avg+"' WHERE id = '"+id+"'";
                    c.s.executeUpdate(q);
                    displayData(id);
                    break;
                case "grade":
                case "Grade":
                case "GRADE":
                    // for editing grade of the student
                    System.out.print("Enter the grade of the student you want to update : ");
                    grade = sc.nextLine();
                    c = new Conn();
                    q = "UPDATE student SET grade = '"+grade+"' WHERE id = '"+id+"'";
                    c.s.executeUpdate(q);
                    displayData(id);
                    break;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void displayData(int id)
    {
        try
        {
            q = "SELECT * FROM student WHERE id = '"+id+"'";
            rs = c.s.executeQuery(q);
            if(rs.next())
            {
                sidText.setText(Integer.toString(rs.getInt(1)));
                snameText.setText(rs.getString(2));
                courseText.setText(rs.getString(3));
                mark1Text.setText(Integer.toString(rs.getInt(4)));
                mark2Text.setText(Integer.toString(rs.getInt(5)));
                mark3Text.setText(Integer.toString(rs.getInt(6)));
                mark4Text.setText(Integer.toString(rs.getInt(7)));
                mark5Text.setText(Integer.toString(rs.getInt(8)));
                avgText.setText(Integer.toString(rs.getInt(9)));
                gradeText.setText(rs.getString(10));
                repaint();
                getContentPane().validate();
                getContentPane().repaint();
                setVisible(true);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
