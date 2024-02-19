package student_grade_tracker;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener
{
    private void userInput()
    {
        // take input from user and set the input in the respective TextFields
        sc = new Scanner(System.in);
        System.out.print("Enter the student ID : ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the student name : ");
        name = sc.nextLine();
        System.out.print("Enter the course : ");
        scourse = sc.nextLine();
        System.out.print("Enter the marks of the 1st subject : ");
        m1 = sc.nextInt();
        System.out.print("Enter the marks of the 2nd subject : ");
        m2 = sc.nextInt();
        System.out.print("Enter the marks of the 3rd subject : ");
        m3 = sc.nextInt();
        System.out.print("Enter the marks of the 4th subject : ");
        m4 = sc.nextInt();
        System.out.print("Enter the marks of the 5th subject : ");
        m5 = sc.nextInt();
        sidText.setText(Integer.toString(id));
        snameText.setText(name);
        courseText.setText(scourse);
        mark1Text.setText(Integer.toString(m1));
        mark2Text.setText(Integer.toString(m2));
        mark3Text.setText(Integer.toString(m3));
        mark4Text.setText(Integer.toString(m4));
        mark5Text.setText(Integer.toString(m5));
    }

    // initialize all the components
    JLabel sid,sname,course,mark1,mark2,mark3,mark4,mark5;
    JTextField sidText,snameText,courseText,mark1Text,mark2Text,mark3Text,mark4Text,mark5Text;
    JButton add;
    ResultSet rs;
    Scanner sc;
    String name,scourse,q,grade;
    int id,m1,m2,m3,m4,m5,sum,avg;
    AddStudent()
    {
        try
        {
            setTitle("Student Grade Tracker");  // sets the title for the program
            setSize(800,740);
            setLayout(null);
            setVisible(false);
            setResizable(false);
            setLocation(550,150);
            getContentPane().setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            sid = new JLabel("The entered student ID is : ");
            sid.setBounds(45,50,600,40);
            sid.setFont(new Font("Raleway",Font.BOLD,26));
            add(sid);
            sidText = new JTextField();
            sidText.setBounds(530,50,200,40);
            sidText.setFont(new Font("Arial",Font.PLAIN,20));
            sidText.setBackground(Color.WHITE);
            sidText.setForeground(Color.BLACK);
            add(sidText);

            sname = new JLabel("The entered student name is : ");
            sname.setBounds(45,120,600,40);
            sname.setFont(new Font("Raleway",Font.BOLD,26));
            add(sname);
            snameText = new JTextField();
            snameText.setBounds(530,120,200,40);
            snameText.setFont(new Font("Arial",Font.PLAIN,20));
            snameText.setBackground(Color.WHITE);
            snameText.setForeground(Color.BLACK);
            add(snameText );

            course = new JLabel("The entered course is : ");
            course.setBounds(45,190,600,40);
            course.setFont(new Font("Raleway",Font.BOLD,26));
            add(course);
            courseText = new JTextField();
            courseText.setBounds(530,190,200,40);
            courseText.setFont(new Font("Arial",Font.PLAIN,20));
            courseText.setBackground(Color.WHITE);
            courseText.setForeground(Color.BLACK);
            add(courseText);

            mark1 = new JLabel("The entered marks of 1st subject are : ");
            mark1.setBounds(45,260,600,40);
            mark1.setFont(new Font("Raleway",Font.BOLD,26));
            add(mark1);
            mark1Text = new JTextField();
            mark1Text.setBounds(530,260,200,40);
            mark1Text.setFont(new Font("Arial",Font.PLAIN,20));
            mark1Text.setBackground(Color.WHITE);
            mark1Text.setForeground(Color.BLACK);
            add(mark1Text);

            mark2 = new JLabel("The entered marks of 2nd subject are : ");
            mark2.setBounds(45,330,600,40);
            mark2.setFont(new Font("Raleway",Font.BOLD,26));
            add(mark2);
            mark2Text = new JTextField();
            mark2Text.setBounds(530,330,200,40);
            mark2Text.setFont(new Font("Arial",Font.PLAIN,20));
            mark2Text.setBackground(Color.WHITE);
            mark2Text.setForeground(Color.BLACK);
            add(mark2Text);

            mark3 = new JLabel("The entered marks of 3rd subject are : ");
            mark3.setBounds(45,400,600,40);
            mark3.setFont(new Font("Raleway",Font.BOLD,26));
            add(mark3);
            mark3Text = new JTextField();
            mark3Text.setBounds(530,400,200,40);
            mark3Text.setFont(new Font("Arial",Font.PLAIN,20));
            mark3Text.setBackground(Color.WHITE);
            mark3Text.setForeground(Color.BLACK);
            add(mark3Text);

            mark4 = new JLabel("The entered marks of 4th subject are : ");
            mark4.setBounds(45,470,600,40);
            mark4.setFont(new Font("Raleway",Font.BOLD,26));
            add(mark4);
            mark4Text = new JTextField();
            mark4Text.setBounds(530,470,200,40);
            mark4Text.setFont(new Font("Arial",Font.PLAIN,20));
            mark4Text.setBackground(Color.WHITE);
            mark4Text.setForeground(Color.BLACK);
            add(mark4Text);

            mark5 = new JLabel("The entered marks of 5th subject are : ");
            mark5.setBounds(45,540,600,40);
            mark5.setFont(new Font("Raleway",Font.BOLD,26));
            add(mark5);
            mark5Text = new JTextField();
            mark5Text.setBounds(530,540,200,40);
            mark5Text.setFont(new Font("Arial",Font.PLAIN,20));
            mark5Text.setBackground(Color.WHITE);
            mark5Text.setForeground(Color.BLACK);
            add(mark5Text);

            add = new JButton("Add");
            add.setBackground(Color.BLACK);
            add.setForeground(Color.WHITE);
            add.setFont(new Font("Arial",Font.PLAIN,20));
            add.setBounds(630,610,100,40);
            add(add);
            add.addActionListener(this);
            userInput();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int id = Integer.parseInt(sidText.getText());
        String name = snameText.getText();
        String course = courseText.getText();
        int m1 = Integer.parseInt(mark1Text.getText());
        int m2 = Integer.parseInt(mark2Text.getText());
        int m3 = Integer.parseInt(mark3Text.getText());
        int m4 = Integer.parseInt(mark4Text.getText());
        int m5 = Integer.parseInt(mark5Text.getText());
        sum = m1+m2+m3+m4+m5;
        avg = sum/5;
        grade = "";
        // grading
        if(avg>=90)
        {
            grade = "O";
        }
        else if(avg>=80)
        {
            grade = "A";
        }
        else if(avg>=70)
        {
            grade = "B";
        }
        else if(avg>=60)
        {
            grade = "C";
        }
        else if(avg>=50)
        {
            grade = "D";
        }
        else if(avg>=35)
        {
            grade = "E";
        }
        else
        {
            grade = "F";
        }

        // Validation
        if(m1>100)
        {
            JOptionPane.showMessageDialog(null,"Marks should be less than 100");
            setVisible(false);
            userInput();
            setVisible(true);
        }
        else if(m2>100)
        {
            JOptionPane.showMessageDialog(null,"Marks should be less than 100");
            setVisible(false);
            userInput();
            setVisible(true);
        }
        else if(m3>100)
        {
            JOptionPane.showMessageDialog(null,"Marks should be less than 100");
            setVisible(false);
            userInput();
            setVisible(true);
        }
        else if(m4>100)
        {
            JOptionPane.showMessageDialog(null,"Marks should be less than 100");
            setVisible(false);
            userInput();
            setVisible(true);
        }
        else if(m5>100)
        {
            JOptionPane.showMessageDialog(null,"Marks should be less than 100");
            setVisible(false);
            userInput();
            setVisible(true);
        }
        else
        {
            try
            {
                Conn c = new Conn();
                q = "INSERT INTO student VALUES('"+id+"','"+name+"','"+course+"','"+m1+"','"+m2+"','"+m3+"','"+m4+"','"+m5+"','"+avg+"','"+grade+"')";
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Added successfully");
                setVisible(false);
                new Home().setVisible(true);
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{  // loads all the components on startup
            AddStudent ob = new AddStudent();
            ob.setVisible(true);
        });
    }
}
