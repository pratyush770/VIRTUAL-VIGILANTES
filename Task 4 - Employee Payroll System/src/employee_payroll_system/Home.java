package employee_payroll_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener
{
    // initialize all the components
    JButton add,display,exit;
    JLabel l,text,select;
    ImageIcon i,i3;
    Image i2;
    public Home()
    {
        try
        {
            setTitle("Employee Payroll System");  // sets the title for the program
            setSize(800,420); // defines the size of the frame
            setLayout(null);
            setVisible(true);  // makes the frame visible
            setLocation(550,320);  // opens the frame at the center of the screen
            setResizable(false);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // closes the window and stops the program
            i = new ImageIcon(ClassLoader.getSystemResource("icons/employee.png"));  // loads the image
            i2 = i.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);  // adjusts the size of the image
            i3 = new ImageIcon(i2);  // convert the image to ImageIcon to add it in frame
            l = new JLabel(i3);
            l.setBounds(90,20,100,100);
            add(l);

            text = new JLabel("Employee Payroll System");  // creates a label
            text.setBounds(215,55,550,40);  // for aligning
            text.setFont(new Font("Arial",Font.BOLD,38));
            add(text);

            select = new JLabel("Select an option");  // creates a label
            select.setBounds(285,175,400,40);
            select.setFont(new Font("Raleway",Font.BOLD,28));
            add(select);

            add = new JButton("Add Employee");
            add.setBounds(50,285,200,40);
            add.setFont(new Font("Arial",Font.PLAIN,20));
            add.setBackground(Color.black);
            add.setForeground(Color.white);
            add(add);
            add.addActionListener(this);

            display = new JButton("Display Details");
            display.setBounds(310,285,200,40);
            display.setFont(new Font("Arial",Font.PLAIN,20));
            display.setBackground(Color.black);
            display.setForeground(Color.white);
            add(display);
            display.addActionListener(this);

            exit = new JButton("Exit");
            exit.setBounds(580,285,150,40);
            exit.setFont(new Font("Arial",Font.PLAIN,20));
            exit.setBackground(Color.black);
            exit.setForeground(Color.white);
            add(exit);
            exit.addActionListener(this);
            getContentPane().setBackground(Color.WHITE);  // changes the color of the frame
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            setVisible(false);
            new AddEmployee().setVisible(true);  // goes to add student class
        }
        else if(ae.getSource()==display)
        {
            setVisible(false);
            new DisplayEmployee().setVisible(true);  // goes to display grades class
        }
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
    }
    public static void main(String [] args)
    {
            Home ob = new Home();
    }
}
